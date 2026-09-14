package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentNotificationPortletKeys;
import com.mypage.agencyportal.dto.PaginationDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentNotificationLocalService;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalService;

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
		"javax.portlet.name=" + AgentNotificationPortletKeys.AGENT_NOTIFICATION,
		"mvc.command.name=/data/agentnotification"
	},
	service = MVCResourceCommand.class
)
public class AgentNotificationMVCResourceCommand extends BaseMVCResourceCommand {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentNotificationMVCResourceCommand.class);
	private static Gson gson = new Gson();
	private static int size = 10;
	private static String deptoreCode = StringPool.BLANK;
	private static String apiRequestTokenRenew = StringPool.BLANK;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		long notificationId = 0L;
		int page = ParamUtil.getInteger(httpRequest, "page");
		if (Validator.isNotNull(ParamUtil.getString(httpRequest, "target"))) {
	        String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "target"));
			String[] paramSplit = param.split("\\|");
			notificationId = Long.parseLong(paramSplit[1]);
        }
		String category = ParamUtil.getString(httpRequest, "category");
		
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
		
		if (page > 0) {
			List<String> categoryNotifications = new ArrayList<String>();
			List<String> categoryMessages = new ArrayList<String>();
			MypageUser myPageUser = _mypageUserLocalService.getByDeptoreCode(deptoreCode);
			List<Long> groups = MypageUserGroupLocalServiceUtil.findBymypageUserId(myPageUser.getMypageUserId());
			
			List<MasterGlobalVariable> variables = category.equalsIgnoreCase("notifikasi") == true ? 
					MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification") :
					MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Message");
					
			if (variables.size() > 0) {
				for (MasterGlobalVariable item : variables) {
					if (category.equalsIgnoreCase("notifikasi") == true) categoryNotifications.add(item.getValue());
					if (category.equalsIgnoreCase("pesan") == true) categoryMessages.add(item.getValue());
				}
			}
			
			if (helpers.isLog()) _log.info(categoryNotifications);
			if (helpers.isLog()) _log.info(categoryMessages);
					
			List<AgentNotification> itemList = category.equalsIgnoreCase("notifikasi") == true ? 
					AgentNotificationLocalServiceUtil.getActiveNotificationByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryNotifications) :
					AgentNotificationLocalServiceUtil.getActiveNotificationByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryMessages);
					
			if (helpers.isLog()) _log.info(itemList);
					
			int totalItems = itemList.size();
	        int totalPages = (int) Math.ceil((double) totalItems / size);
	        
	        if (page > totalPages) page = totalPages;
	        
	        int start = (page - 1) * size;
	        int end = page * size;
	        
	        List<AgentNotification> items = category.equalsIgnoreCase("notifikasi") == true ? 
	        		_agentNotificationLocalService.findByFilter(start, end, myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryNotifications) :
	        		_agentNotificationLocalService.findByFilter(start, end, myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryMessages);
	        
	        if (helpers.isLog()) _log.info(items);
	        		
	        JSONArray _items = JSONFactoryUtil.createJSONArray();
	        
	        for (AgentNotification item : items) {
	        	JSONObject _item = JSONFactoryUtil.createJSONObject();
	        	
	        	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
	        	Date startDate = dateFormat.parse(item.getCreateDate().toString()); //, endDate = null;
//	            if (Validator.isNotNull(item.getStartDate())) startDate = dateFormat.parse(item.getCreateDate().toString());
//	            if (Validator.isNotNull(item.getEndDate())) endDate = dateFormat.parse(item.getEndDate().toString());
//	            if (item.getCategory().equalsIgnoreCase("sales tools") || item.getCategory().equalsIgnoreCase("license agent") || item.getCategory().equalsIgnoreCase("club") || item.getCategory().contains("transaksi")) startDate = dateFormat.parse(item.getCreateDate().toString());
	            
	            dateFormat = new SimpleDateFormat("d MMM yyyy");
	            String formattedDate = StringPool.BLANK;
//	            if (item.getIsAllDay() == 1 && Validator.isNull(item.getEndDate())) {
	            	formattedDate = dateFormat.format(startDate);
//	            }
//	            if (item.getIsAllDay() == 1 && Validator.isNotNull(item.getEndDate())) {
//	            	if (item.getStartDate().equals(item.getEndDate())) {
//	            		formattedDate = dateFormat.format(startDate);
//	            	} else {
//	            		formattedDate = dateFormat.format(startDate).concat(" - ").concat(dateFormat.format(endDate));
//	            	}
//	            }
//	            if (item.getIsAllDay() == 0 && Validator.isNull(item.getEndDate())) {
//	            	formattedDate = dateFormat.format(startDate).concat(" | ").concat(item.getStartTime());
//	            }
//	            if (item.getIsAllDay() == 0 && (Validator.isNotNull(item.getStartDate()) && Validator.isNotNull(item.getEndDate()))) {
//	            	if (item.getStartDate().equals(item.getEndDate())) {
//	            		formattedDate = dateFormat.format(startDate).concat(" | ").concat(item.getStartTime()).concat(" - ").concat(item.getEndTime());
//	            	} else {
//	            		formattedDate = dateFormat.format(startDate).concat(" - ").concat(dateFormat.format(endDate)).concat(" | ").concat(item.getStartTime()).concat(" - ").concat(item.getEndTime());
//	            	}
//	            }
	            
	            _item.put("target", EncryptionHelper.encryptRandom(String.valueOf(item.getAgentNotificationId())));
	            _item.put("title", item.getTitle());
	            _item.put("description", item.getDescription().replace("Agen, ", myPageUser.getUserName().concat(",<br>")));
	            _item.put("date", formattedDate);
	            if (Validator.isNotNull(item.getLocation())) _item.put("location", item.getLocation());
	            
	            String link = item.getLink();
	            if (item.getCategory().equalsIgnoreCase("transaksi berhasil") == true || item.getCategory().equalsIgnoreCase("transaksi kedaluwarsa") == true) {
		            String[] parts = item.getLink().split("/");
		            String lastPart = parts[parts.length - 1];
		            String newLastPart = EncryptionHelper.encryptRandom(lastPart);
		            link = item.getLink().substring(0, item.getLink().lastIndexOf("/") + 1) + newLastPart;
	            }
	            _item.put("link", link);
	            
	            if (item.getReferenceId() > 0) _item.put("reference", EncryptionHelper.encryptRandom(String.valueOf(item.getReferenceId())));
				_item.put("isRead", item.getIsRead() == 1 ? true : false);
	            
	            _items.put(_item);
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
	        return;
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentNotificationMVCResourceCommand.class.getName(),
				resourceRequest);
		
		_agentNotificationLocalService.setIsRead(notificationId, 1, serviceContext);
		
		_response.put("status", true);
        _response.put("message", StringPool.BLANK);
        _response.put("token", apiRequestTokenRenew);
        
        resourceResponse.getWriter().write(_response.toString());
	}

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
	
	@Reference
	private AgentNotificationLocalService _agentNotificationLocalService;
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
}
