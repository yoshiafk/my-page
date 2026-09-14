package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentSalesToolsPortletKeys;
import com.mypage.agencyportal.dto.PaginationDto;
import com.mypage.agencyportal.dto.SalesToolsDto;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.model.AgentSalesTools;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentSalesToolsLocalService;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.service.MypageUserLocalService;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AgentSalesToolsPortletKeys.AGENT_SALES_TOOLS,
		"mvc.command.name=/data/agentsalestools"
	},
	service = MVCResourceCommand.class
)
public class AgentSalesToolsMVCResourceCommand extends BaseMVCResourceCommand {
	private static Gson gson = new Gson();
	private static int size = 10;
	private static String deptoreCode = StringPool.BLANK;
	private static String apiRequestTokenRenew = StringPool.BLANK;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		long salesToolsId = 0L;
        int page = ParamUtil.getInteger(httpRequest, "page");
        String title = ParamUtil.getString(httpRequest, "title");
        String category = ParamUtil.getString(httpRequest, "category");
        if (Validator.isNotNull(ParamUtil.getString(httpRequest, "target"))) {
	        String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "target"));
			String[] paramSplit = param.split("\\|");
	        salesToolsId = Long.parseLong(paramSplit[1]);
        }
        
        /* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			AgentToken renewAgentApiRequestToken = _agentTokenLocalService.renewAgentToken(verifyAgentToken.getAgentTokenId());

			if (!Validator.isNull(renewAgentApiRequestToken)) {
				apiRequestTokenRenew = renewAgentApiRequestToken.getApiRequestToken();
			}

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		/* END Validate API Request Token */
        
        if (category.equalsIgnoreCase("view")) {
        	SalesToolsDto _item = new SalesToolsDto();
        	AgentSalesTools item = _agentSalesToolsLocalService.fetchAgentSalesTools(salesToolsId);
        	
        	if (Validator.isNotNull(item)) {
        		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        		Date date = null;
        		try {
                    date = dateFormat.parse(item.getCreateDate().toString());
        		} catch(Exception e) {
        			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        			date = dateFormat.parse(item.getCreateDate().toString());
        		}
                
                dateFormat = new SimpleDateFormat("d MMM yyyy");
                String formatted = dateFormat.format(date);
        		
                _item.setTarget(EncryptionHelper.encryptRandom(String.valueOf(salesToolsId)));
            	_item.setTitle(item.getTitle());
            	_item.setCategory(item.getCategory());
            	_item.setDescription(item.getDescription());
            	_item.setDateFormat(formatted);
            	_item.setFilePath(item.getFileUploadUrl());
        	}
        	
        	_data.put("item", gson.fromJson(gson.toJson(_item), Object.class));
        	_response.put("status", true);
			_response.put("message", "");
			_response.put("data", _data);
			_response.put("token", apiRequestTokenRenew);
			
			resourceResponse.getWriter().write(_response.toString());
			return;
        }
        
        if (category.equalsIgnoreCase("download")) {
        	AgentSalesTools item = _agentSalesToolsLocalService.fetchAgentSalesTools(salesToolsId);
        	
        	FileEntry file = DLAppLocalServiceUtil.getFileEntry(item.getFileUploadEntryId());
        	byte[] fileBytes = FileUtil.getBytes(file.getContentStream());

	        resourceResponse.setContentType(file.getMimeType());
	        resourceResponse.addProperty("Aptoken", apiRequestTokenRenew);
	        resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	        resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFileName());

	        try (OutputStream outputStream = resourceResponse.getPortletOutputStream()) {
	            outputStream.write(fileBytes);
	        }
			
			return;
        }
        
        category = category.equalsIgnoreCase("lihat semua") ? StringPool.BLANK : category;
        
        long role = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getMypageUserRoleId();
        int totalItems = _agentSalesToolsLocalService.getCountByFilter(title, category, role);
        int totalPages = (int) Math.ceil((double) totalItems / size);
        
        if (page > totalPages) page = totalPages;
        
        int start = (page - 1) * size;
        int end = page * size;
        
        List<AgentSalesTools> items = _agentSalesToolsLocalService.findByFilter(start, end, title, category, role);
        
        List<SalesToolsDto> _items = new ArrayList<SalesToolsDto>();
        
        for (AgentSalesTools item : items) {
        	SalesToolsDto _item = new SalesToolsDto();
        	
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(item.getCreateDate().toString());
            
            dateFormat = new SimpleDateFormat("d MMM yyyy");
            String formatted = dateFormat.format(date);
            
            FileEntry image = Validator.isNull(item.getFileUploadEntryId()) ? null : DLAppLocalServiceUtil.getFileEntry(item.getFileUploadEntryId());
			String extension = image == null ? StringPool.BLANK : image.getExtension();
            
			_item.setTarget(EncryptionHelper.encryptRandom(String.valueOf(item.getAgentSalesToolsId())));
        	_item.setTitle(item.getTitle());
        	_item.setCategory(item.getCategory());
        	_item.setDateFormat(formatted);
        	_item.setExtension(extension);
            
            _items.add(_item);
        }
        
        PaginationDto pagination = new PaginationDto();
        pagination.setItemPerPage(size);
        pagination.setPage(page);
        pagination.setTotalItem(totalItems);
        pagination.setTotalPage(totalPages);
        
        _data.put("items", _items);
        _data.put("paging", gson.fromJson(gson.toJson(pagination), Object.class));
        _response.put("status", true);
        _response.put("message", "");
        _response.put("data", _data);
        _response.put("token", apiRequestTokenRenew);
        
        resourceResponse.getWriter().write(_response.toString());
	}
	
	@Reference
	private AgentSalesToolsLocalService _agentSalesToolsLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
}
