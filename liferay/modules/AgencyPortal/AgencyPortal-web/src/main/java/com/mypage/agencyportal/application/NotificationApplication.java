package com.mypage.agencyportal.application;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentNotificationPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.SignatureHelper;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
		property = {
			JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/notification",
			JaxrsWhiteboardConstants.JAX_RS_NAME + "=Notification.Rest",
			"auth.verifier.guest.allowed=true",
			"liferay.access.control.disable=true"
		},
		service = Application.class
	)
public class NotificationApplication extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CorsFilterHelper.class);

		return classes;
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public String createNotification(String request, @Context HttpHeaders headers) throws Exception {
		JsonObject jsonObject = JsonParser.parseString(request).getAsJsonObject();
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		ActionHelpers helpers = new ActionHelpers();

		String title = StringPool.BLANK;
		String description = StringPool.BLANK;
		String link = StringPool.BLANK;
		String blank = StringPool.BLANK;
//		String formattedDate = StringPool.BLANK;
//		String formattedTime = StringPool.BLANK;
		String uuid = headers.getHeaderString("Request-Id");
        String reqTimestamp = headers.getHeaderString("Request-Timestamp");
		String signature = headers.getHeaderString("Signature");

		String category = jsonObject.get("Category").getAsString();
		String deptoreCode = jsonObject.get("Code").getAsString();
//		String name = jsonObject.get("Name").getAsString();
//		String refNumber = jsonObject.get("ReferenceNumber").getAsString();
//		String date = jsonObject.get("Date").getAsString();
		String id = jsonObject.get("Oid").getAsString();
		String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
		
//		try {
//			LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));
//			formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//	        formattedTime = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
//		} catch (Exception e) {
//			_output.put("status", false);
//    		_output.put("message", "Parse error");
//    		
//    		return _output.toString();
//		}
		
		if (category.equalsIgnoreCase("transaksi berhasil")) {
			MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification Template")
											.stream().filter(v -> v.getName().equalsIgnoreCase("transaksi berhasil") && v.getActive() == 1)
											.findFirst().get();
			title = variable.getName();
			description = variable.getValue();
			link = host.concat("/dashboard/leads/online/").concat(id);
		}
		
		if (category.equalsIgnoreCase("transaksi kedaluwarsa")) {
			MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification Template")
											.stream().filter(v -> v.getName().equalsIgnoreCase("transaksi kedaluwarsa") && v.getActive() == 1)
											.findFirst().get();
			title = variable.getName();
			description = variable.getValue();
			link = host.concat("/dashboard/leads/online/").concat(id);
		}
		
		if (category.equalsIgnoreCase("transaksi acl")) {
			MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification Template")
											.stream().filter(v -> v.getName().equalsIgnoreCase("transaksi acl") && v.getActive() == 1)
											.findFirst().get();
			title = variable.getName();
			description = variable.getValue();
			link = host.concat("/dashboard/leads-settlement");
		}
		
        String generateSignature = SignatureHelper.generateSignature(deptoreCode, uuid, reqTimestamp, SignatureHelper.generateDigest(jsonObject.toString()));
        
        if (signature.equalsIgnoreCase(generateSignature) == false) {
        	_output.put("status", false);
    		_output.put("message", "Access Forbidden");
    		
    		return _output.toString();
        }
		
		MypageUser myPageUser = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);
		
		AgentNotificationLocalServiceUtil.addNotification(title, blank, blank, description, link, category, 0L, 0L, 0L,
				"", "", blank, blank, blank, 0L, 0, 1, myPageUser.getMypageUserId());
		
		_output.put("status", true);
		_output.put("message", AgentNotificationPortletKeys.MSG_CREATE_SUCCESS);

		return _output.toString();
	}
	
	@POST
	@Path("/get-unreads")
	@Produces("application/json")
	public String getUnreads(String request, @Context HttpHeaders headers) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		String uuid = headers.getHeaderString("Request-Id");
        String reqTimestamp = headers.getHeaderString("Request-Timestamp");
		String signature = headers.getHeaderString("Signature");
		
		String deptoreCode = params.getString("Code");
		
		String generateSignature = SignatureHelper.generateSignature(deptoreCode, uuid, reqTimestamp, SignatureHelper.generateDigest(params.toString()));
        
        if (signature.equalsIgnoreCase(generateSignature) == false) {
        	_output.put("status", false);
    		_output.put("message", "Access Forbidden");
    		
    		return _output.toString();
        }
        
        MypageUser myPageUser = null;
        List<Long> groups = new ArrayList<Long>();
		
        try {
        	myPageUser = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);
        	groups = MypageUserGroupLocalServiceUtil.findBymypageUserId(myPageUser.getMypageUserId());
        } catch (Exception e) {
        	_data.put("unreads", 0);
    		_output.put("status", true);
    		_output.put("message", StringPool.BLANK);
    		_output.put("data", _data);
    		
    		return _output.toString();
        }
		
		List<AgentNotification> notifications = AgentNotificationLocalServiceUtil.getUnreadNotificationByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups);
		
		_data.put("unreads", notifications.size());
		_output.put("status", true);
		_output.put("message", StringPool.BLANK);
		_output.put("data", _data);

		return _output.toString();
	}
}
