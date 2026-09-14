package com.mypage.agencyportal.application.mobileapps;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.service.AgentCalendarLocalService;
import com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil;
import com.mypage.agencyportal.service.AgentEmailBucketLocalServiceUtil;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * REST API endpoint for Calendar.
 */
@Component(
	    property = {
	        "osgi.jaxrs.application.base=/calendar",
	        "osgi.jaxrs.name=Calendar.Rest",
	        "auth.verifier.guest.allowed=true",
	        "liferay.access.control.disable=true"
	    },
	    service = Application.class
	)

@Path("/v2")
public class CalendarApplication extends Application {

	@Context
	private HttpServletRequest httpRequest;

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CorsFilterHelper.class);
		return classes;
	}

	private static final Log _log = LogFactoryUtil.getLog(CalendarApplication.class);
	private JwtKeyService _jwtKeyService;

	@Reference
	protected void setJwtKeyService(JwtKeyService jwtKeyService) {
		this._jwtKeyService = jwtKeyService;
		_log.info("JwtKeyService has been injected into CalendarApplication");
	}

	/**
	 * Get calendar event details by ID.
	 *
	 * @param requestBody JSON containing eventId
	 * @return JSON response with calendar event details
	 */
	@POST
	@Path("/detail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendarEventDetail(@HeaderParam("Authorization") String authHeader, String requestBody) {
	    _log.info("[CalendarApplication] Get calendar event detail endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

	        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid Authorization header")).build();
	        }

	        String jwtToken = authHeader.substring(BEARER_PREFIX.length());

	        // Validate token
	        SecretKey key = _jwtKeyService.getKey();
	        Claims claims = Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(jwtToken)
	                .getBody();

	        String deptoreCode = claims.getSubject();
	        Date expiration = claims.getExpiration();

	        MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }
	        
	        if(user == null) {
	        	return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found"))
	                    .build();
	        }

	        // Check if eventId is present
	        if (!jsonRequest.has("eventId")) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("eventId is required")).build();
	        }

	        long eventId = jsonRequest.getLong("eventId");

	        // Fetch calendar
	        AgentCalendar calendar = AgentCalendarLocalServiceUtil.fetchAgentCalendar(eventId);
	        if (calendar == null) {
	            return Response.status(Response.Status.NOT_FOUND)
	                    .entity(createErrorResponse("Calendar event not found")).build();
	        }


	        // Build response
	        JSONObject response = JSONFactoryUtil.createJSONObject();
	        response.put("status", 1);

	        JSONObject data = JSONFactoryUtil.createJSONObject();
	        JSONObject event = JSONFactoryUtil.createJSONObject();

	        event.put("id", calendar.getAgentCalendarId());
	        event.put("title", calendar.getTitle());
	        event.put("description", calendar.getDescription());

	        // Format date
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        
            Date startDate = calendar.getStartDate();
            event.put("startDate", startDate != null ? startDate.getTime() : ""); // as timestamp
            event.put("startDateFormatted", startDate != null ? sdf.format(startDate) : "");

            Date endDate = calendar.getEndDate();
            event.put("endDate", endDate != null ? endDate.getTime() : ""); // as timestamp
            event.put("endDateFormatted", endDate != null ? sdf.format(endDate) : "");

	        event.put("startTime", calendar.getStartTime());
	        event.put("endTime", calendar.getEndTime());
	        event.put("category", calendar.getCategory());
	        event.put("active", calendar.getActive());
	        event.put("mypageUserId", calendar.getMypageUserId());
	        event.put("mypageUserRoleId", calendar.getMypageUserRoleId());
	        event.put("mypageUserGroupId", calendar.getGroupId());
	        event.put("location", calendar.getLocation());
	        event.put("address", calendar.getAddress());
	        event.put("link", calendar.getLink());
	        event.put("role", calendar.getRole());
	        event.put("group", calendar.getGroup());
	        event.put("isAllDay", calendar.getIsAllDay());
	        event.put("ownerName", user.getUserName());
	        event.put("ownerEmail", user.getEmail());

	        data.put("event", event);
	        response.put("data", data);

	        _log.info("[CalendarApplication] Successfully retrieved calendar event details for ID: " + eventId);
	        return Response.ok(response.toString()).build();

	    } catch (ExpiredJwtException e) {
	        _log.error("[CalendarApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[CalendarApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[CalendarApplication] Error retrieving calendar event details: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving calendar event details: " + e.getMessage())).build();
	    }
	}

	
	
	@POST
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalendars(@HeaderParam("Authorization") String authHeader) {
	    _log.info("[CalendarApplication] Get calendar getCalendars endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid Authorization header")).build();
	        }

	        String jwtToken = authHeader.substring(BEARER_PREFIX.length());

	        // Validate token
	        SecretKey key = _jwtKeyService.getKey();
	        Claims claims = Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(jwtToken)
	                .getBody();

	        String deptoreCode = claims.getSubject();
	        Date expiration = claims.getExpiration();

	        MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }

	        if (user == null) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found")).build();
	        }

	        // Filter dan urutkan kalender
	        Calendar cal = Calendar.getInstance();
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        Date todayStart = cal.getTime(); // jam 00:00 hari ini

	        List<AgentCalendar> activeCalendars = AgentCalendarLocalServiceUtil.getAgentCalendars(-1, -1)
	        	    .stream()
	        	    .filter(c -> c.getActive() == 1) //if active
	        	    .filter(c -> {
	        	        if ("reminder".equalsIgnoreCase(c.getCategory())) {
	        	            return c.getMypageUserId() == user.getMypageUserId(); //jika bukan event filter by user id matching, jika event show true
	        	        }
	        	        return true; // kategori selain reminder lolos filter ini
	        	    })
	        	    .filter(c -> {
	        	        Date endDate = c.getEndDate();
	        	        return (endDate == null || !endDate.before(todayStart)); // tampilkan jika endDate null atau >= hari ini
	        	    })
	        	    .sorted(Comparator.comparing(AgentCalendar::getStartDate, Comparator.nullsLast(Comparator.naturalOrder())))
	        	    .collect(Collectors.toList());


	        _log.info("activeCalendars size >> " + activeCalendars.size());

	        // Build response
	        JSONObject response = JSONFactoryUtil.createJSONObject();
	        response.put("status", 1);

	        JSONArray eventsArray = JSONFactoryUtil.createJSONArray();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	        for (AgentCalendar calendar : activeCalendars) {
	            JSONObject event = JSONFactoryUtil.createJSONObject();

	            event.put("id", calendar.getAgentCalendarId());
	            event.put("title", calendar.getTitle());
	            event.put("description", calendar.getDescription());
	            
	            Date startDate = calendar.getStartDate();
	            event.put("startDate", startDate != null ? startDate.getTime() : ""); // as timestamp
	            event.put("startDateFormatted", startDate != null ? sdf.format(startDate) : "");

	            Date endDate = calendar.getEndDate();
	            event.put("endDate", endDate != null ? endDate.getTime() : ""); // as timestamp
	            event.put("endDateFormatted", endDate != null ? sdf.format(endDate) : "");

	            event.put("startTime", calendar.getStartTime());
	            event.put("endTime", calendar.getEndTime());
	            event.put("category", calendar.getCategory());
	            event.put("active", calendar.getActive());
	            event.put("mypageUserId", calendar.getMypageUserId());
	            event.put("mypageUserRoleId", calendar.getMypageUserRoleId());
	            event.put("mypageUserGroupId", calendar.getGroupId());
	            event.put("location", calendar.getLocation());
	            event.put("address", calendar.getAddress());
	            event.put("link", calendar.getLink());
	            event.put("role", calendar.getRole());
	            event.put("group", calendar.getGroup());
	            event.put("isAllDay", calendar.getIsAllDay());

	            MypageUser userCal = MypageUserLocalServiceUtil.fetchMypageUser(calendar.getMypageUserId());
	            if (userCal != null) {
	                event.put("ownerName", userCal.getUserName());
	                event.put("ownerEmail", userCal.getEmail());
	            } else {
	                event.put("ownerName", "");
	                event.put("ownerEmail", "");
	            }

	            eventsArray.put(event);
	        }

	        JSONObject data = JSONFactoryUtil.createJSONObject();
	        data.put("events", eventsArray);
	        response.put("data", data);

	        _log.info("[CalendarApplication] Successfully retrieved calendar");
	        return Response.ok(response.toString()).build();

	    } catch (ExpiredJwtException e) {
	        _log.error("[CalendarApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[CalendarApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[CalendarApplication] Error retrieving calendar: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving calendar: " + e.getMessage())).build();
	    }
	}

	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCalendar(@HeaderParam("Authorization") String authHeader, String requestBody) {
	    _log.info("[CalendarApplication] Create calendar endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

	        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid Authorization header")).build();
	        }

	        String jwtToken = authHeader.substring(BEARER_PREFIX.length());

	        SecretKey key = _jwtKeyService.getKey();
	        Claims claims = Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(jwtToken)
	                .getBody();

	        String deptoreCode = claims.getSubject();
	        Date expiration = claims.getExpiration();
	        MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }
	        
	        if(user == null) {
	        	return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found"))
	                    .build();
	        }

	        ActionHelpers helpers = new ActionHelpers();
	        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat dashFormat = new SimpleDateFormat("yyyy-MM-dd");

	        String title = helpers.sanitizeHtml(jsonRequest.getString("title"));
	        String dateStr = jsonRequest.getString("startDate");
	        String time = jsonRequest.getString("startTime", "");
	        
	        String dateStr2 = jsonRequest.getString("endDate");
	        String time2 = jsonRequest.getString("endTime", "");
	        
	        String description = helpers.sanitizeHtml(jsonRequest.getString("description", ""));
	        String link = helpers.sanitizeHtml(jsonRequest.getString("link", ""));
	        String category = jsonRequest.getString("category", "Reminder");
	        int isAllDay = jsonRequest.getInt("isAllDay", 0);
	        long mypageUserId =  user.getMypageUserId(); //jsonRequest.getLong("mypageUserId");

	        
	        
	        // Cek category Event
	        if ("Event".equalsIgnoreCase(category)) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("Tidak bisa membuat calendar dengan tipe Event")).build();
	        }

	        // Validasi title
	        if (Validator.isNull(title)) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("Judul tidak boleh kosong")).build();
	        }

	        // Validasi waktu
	        if (Validator.isNotNull(time)) {
	            String timeRegex = "^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$";
	            Pattern pattern = Pattern.compile(timeRegex);
	            Matcher matcher = pattern.matcher(time);

	            if (!matcher.matches()) {
	                return Response.status(Response.Status.BAD_REQUEST)
	                        .entity(createErrorResponse("Format waktu tidak valid")).build();
	            }

	            String[] arrTime = time.split(":");
	            int hour = Integer.parseInt(arrTime[0]);
	            int min = Integer.parseInt(arrTime[1]);

	            if (hour > 23 || min > 59) {
	                return Response.status(Response.Status.BAD_REQUEST)
	                        .entity(createErrorResponse("Nilai jam atau menit tidak valid")).build();
	            }
	        }
	        
	        //end time
	        if (Validator.isNotNull(time2)) {
	            String timeRegex = "^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$";
	            Pattern pattern = Pattern.compile(timeRegex);
	            Matcher matcher = pattern.matcher(time2);

	            if (!matcher.matches()) {
	                return Response.status(Response.Status.BAD_REQUEST)
	                        .entity(createErrorResponse("Format waktu tidak valid")).build();
	            }

	            String[] arrTime = time2.split(":");
	            int hour = Integer.parseInt(arrTime[0]);
	            int min = Integer.parseInt(arrTime[1]);

	            if (hour > 23 || min > 59) {
	                return Response.status(Response.Status.BAD_REQUEST)
	                        .entity(createErrorResponse("Nilai jam atau menit tidak valid")).build();
	            }
	        }

	        // Validasi all-day + time
	        if (isAllDay == 1 && (Validator.isNotNull(time) || Validator.isNotNull(time2))) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("Acara sepanjang hari tidak boleh punya jam tertentu")).build();
	        }

	        // Convert tanggal
	        Date parsedDate = inputFormat.parse(dateStr);
	        String formattedDate = dashFormat.format(parsedDate);
	        
	        // Convert tanggal end
	        Date parsedDate2 = inputFormat.parse(dateStr2);
	        String formattedDate2 = dashFormat.format(parsedDate2);

	        // Simpan calendar
	        AgentCalendar calendar = AgentCalendarLocalServiceUtil.addCalendar(
	                title, "", "", description, link, category, 0, 0,
	                formattedDate, time, formattedDate2, time2, "", 0,
	                isAllDay, 1, mypageUserId
	        );

	        // Kirim email & notifikasi
	        String template = "/META-INF/resources/emailtemplate/reminder.ftl";

	        JSONObject params = JSONFactoryUtil.createJSONObject();
	        params.put("name", user.getUserName());
	        params.put("date", inputFormat.format(parsedDate));
	        params.put("time", time);
	        params.put("link", link);
	        params.put("description", description);

	        AgentEmailBucketLocalServiceUtil.addEmailBucket(
	                title, "Reminder AXA MyPage", user.getEmail(),
	                template, params.toString(), "", 0
	        );

	        AgentNotificationLocalServiceUtil.addNotification(
	                title, "", "", description, link, category, 0, 0,
	                calendar.getAgentCalendarId(), formattedDate, time, formattedDate2, time2, "", 0,
	                isAllDay, 1, mypageUserId
	        );

	        JSONObject response = JSONFactoryUtil.createJSONObject();
	        response.put("status", 1);
	        response.put("message", "Calendar berhasil dibuat");

	        JSONObject data = JSONFactoryUtil.createJSONObject();
	        data.put("calendarId", calendar.getAgentCalendarId());
	        response.put("data", data);

	        _log.info("[CalendarApplication] Calendar created successfully");
	        return Response.ok(response.toString()).build();

	    } catch (ExpiredJwtException e) {
	        _log.error("[CalendarApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[CalendarApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[CalendarApplication] Error creating calendar: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error creating calendar: " + e.getMessage())).build();
	    }
	}


	private String createErrorResponse(String message) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		response.put("status", 0);
		response.put("message", message);
		JSONObject data = JSONFactoryUtil.createJSONObject();
		response.put("data", data);
		return response.toString();
	}


	@Reference
	private MasterGlobalVariableLocalService _MasterGlobalVariableLocalService;
	
	@Reference
	private AgentCalendarLocalService agentCalendarLocalService;

}
