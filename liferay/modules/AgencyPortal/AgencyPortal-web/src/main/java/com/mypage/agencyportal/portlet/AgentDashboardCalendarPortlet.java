package com.mypage.agencyportal.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentDashboardCalendarPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentCalendarLocalService;
import com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil;
import com.mypage.agencyportal.service.AgentEmailBucketLocalServiceUtil;
import com.mypage.agencyportal.service.AgentMarkCalendarLocalServiceUtil;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.Portlet;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Agent Dashboard Calendar",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/dashboard/calendar/view.jsp",
			"javax.portlet.name=" + AgentDashboardCalendarPortletKeys.AGENT_DASHBOARD_CALENDAR,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentDashboardCalendarPortlet extends MVCPortlet {
	private static String apiRequestTokenRenew = null;
	private static long userId = 0;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentDashboardCalendarPortlet.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException {

		JSONObject _data = JSONFactoryUtil.createJSONObject();
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		String dataCategory = ParamUtil.getString(httpRequest, "dataCategory");
		
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
			userId = MypageUserLocalServiceUtil.getByDeptoreCode(verifyAgentToken.getDeptCode()).getMypageUserId();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		/* END Validate API Request Token */
		
		if (dataCategory.equalsIgnoreCase("mark")) {
			try {
				String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "target"));
				String[] paramSplit = param.split("\\|");
				long eventId = Long.parseLong(paramSplit[1]);
				
				Date today = new Date();
				today.setHours(0);
				today.setMinutes(0);
				today.setSeconds(0);
				
				long timestamp = Math.round(Math.floor(today.getTime() / 1000.0));
				Date startDate = _agentCalendarLocalService.fetchAgentCalendar(eventId).getStartDate();
				Date endDate = _agentCalendarLocalService.fetchAgentCalendar(eventId).getEndDate();
				
				if ((startDate.getTime() / 1000) > timestamp && Validator.isNull(endDate) == true) {
					_response.put("status", false);
					_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_MARK);
					_response.put("token", apiRequestTokenRenew);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				if (Validator.isNotNull(endDate) == true && (endDate.getTime() / 1000) > timestamp) {
					_response.put("status", false);
					_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_MARK);
					_response.put("token", apiRequestTokenRenew);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				AgentMarkCalendarLocalServiceUtil.addAgentMarkCalendar(eventId, userId);

				String category = _agentCalendarLocalService.fetchAgentCalendar(eventId).getCategory();
				
				if (category.equalsIgnoreCase("reminder") == true) {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentCalendar.class.getName(), resourceRequest);
					_agentCalendarLocalService.setActive(eventId, 0, serviceContext);
				}

				_response.put("status", true);
				_response.put("message", AgentDashboardCalendarPortletKeys.MSG_SUCCESS_MARK);
				_response.put("token", apiRequestTokenRenew);
			} catch (Exception e) {
				_response.put("status", false);
				_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_MARK);
				_response.put("token", apiRequestTokenRenew);
				if (helpers.isLog()) _log.info(e.getMessage());
//				if (helpers.isLog()) _log.info(e.getStackTrace());
			}
		}
		
		if (dataCategory.equalsIgnoreCase("create")) {
			try {
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id"));
				ActionHelpers helpers = new ActionHelpers();
				
				String title = helpers.sanitizeHtml(ParamUtil.getString(httpRequest, "title"));
				String date = ParamUtil.getString(httpRequest, "date");
				String time = ParamUtil.getString(httpRequest, "time");
				String description = helpers.sanitizeHtml(ParamUtil.getString(httpRequest, "description", ""));
				String link = helpers.sanitizeHtml(ParamUtil.getString(httpRequest, "link", ""));
				String category = "Reminder";
				int isAllDay = ParamUtil.getBoolean(httpRequest, "isAllDay", false) ? 1 : 0;
				int active = 1;
				
				if (Validator.isNotNull(time)) {
			        String timeRegex = "^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$";
			        Pattern pattern = Pattern.compile(timeRegex);
			        Matcher matcher = pattern.matcher(time);
			        
		            String[] arrTime = time.split(":");
		            int hour = Integer.parseInt(arrTime[0]);
		            int min = Integer.parseInt(arrTime[1]);
	
			        if (matcher.matches() == false) {
			        	if (helpers.isLog()) _log.info("The format is wrong");
			        	_response.put("status", false);
						_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_CREATE_REMINDER);
						
						resourceResponse.getWriter().write(_response.toString());
						return;
			        }
	
		            if (hour > 23 && min > 59) {
		            	if (helpers.isLog()) _log.info("The time is wrong");
		            	_response.put("status", false);
						_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_CREATE_REMINDER);
						
						resourceResponse.getWriter().write(_response.toString());
						return;
		            }
				}
				
				if (isAllDay == 1 && Validator.isNotNull(time)) {
					if (helpers.isLog()) _log.info("All day active but time isn't null");
					_response.put("status", false);
					_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_CREATE_REMINDER);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				if (Validator.isNull(title)) {
					if (helpers.isLog()) _log.info("The title is empty");
					_response.put("status", false);
					_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_CREATE_REMINDER);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				date = helpers.ConvertDateFormat(inputFormat.parse(date).toString(), "yyyy-MM-dd");
				
				AgentCalendar agentCalendar = AgentCalendarLocalServiceUtil.addCalendar(title, "", "", description, link, category, 0, 0, date, time, "", "", "", 0, isAllDay, active, userId);
				
				String template = "/META-INF/resources/emailtemplate/reminder.ftl";
				MypageUser user = MypageUserLocalServiceUtil.fetchMypageUser(userId);
				SimpleDateFormat dashFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				JSONObject params = JSONFactoryUtil.createJSONObject();
				params.put("name", user.getUserName());
				params.put("date", inputFormat.format(dashFormat.parse(date)));
				params.put("time", time);
				params.put("link", link);
				params.put("description", description);
				
				AgentEmailBucketLocalServiceUtil.addEmailBucket(title, "Reminder AXA MyPage", user.getEmail(), template, params.toString(), "", 0);
				
				AgentNotificationLocalServiceUtil.addNotification(title, "", "", description, link, category, 0, 0, agentCalendar.getAgentCalendarId(), date, time, "", "", "", 0,
						isAllDay, active, userId);
				
				List<Long> groups = MypageUserGroupLocalServiceUtil.findBymypageUserId(userId);
				List<AgentCalendar> events = AgentCalendarLocalServiceUtil.getActiveCalendarByRole(userId, user.getMypageUserRoleId(), groups);
				
				for (AgentCalendar item : events) {
					item.setGroup(EncryptionHelper.encryptRandom(String.valueOf(item.getAgentCalendarId())));
				}

				_data.put("data", events);
				_response.put("status", true);
				_response.put("message", AgentDashboardCalendarPortletKeys.MSG_SUCCESS_CREATE_REMINDER);
				_response.put("data", _data);
				_response.put("token", apiRequestTokenRenew);
			} catch (Exception e) {
				_response.put("status", false);
				_response.put("message", AgentDashboardCalendarPortletKeys.MSG_FAILED_CREATE_REMINDER);
				if (helpers.isLog()) _log.info(e.getMessage());
//				if (helpers.isLog()) _log.info(e.getStackTrace());
			}
		}
		
		resourceResponse.getWriter().write(_response.toString());
	}
	
	@Reference
	private CounterLocalService _counterLocalService;
	
	@Reference
	private AgentCalendarLocalService _agentCalendarLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
