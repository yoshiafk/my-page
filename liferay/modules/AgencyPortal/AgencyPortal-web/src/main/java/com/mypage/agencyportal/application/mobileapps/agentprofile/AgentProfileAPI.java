package com.mypage.agencyportal.application.mobileapps.agentprofile;

import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.upload.UniqueFileNameProvider;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserTimeline;
import com.mypage.user.model.MypageUserWorkingHour;
import com.mypage.user.service.MypageUserTimelineLocalServiceUtil;
import com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil;
import com.mypage.agencyportal.dto.WorkingHourDto;
import com.mypage.agencyportal.helpers.JsonResponseHelper;
import com.mypage.agencyportal.helpers.JwtAuthHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.agencyportal.helpers.SendHttpRequestToPimcore;
import com.mypage.agencyportal.helpers.JwtAuthHelper.AuthResult;
import com.mypage.agencyportal.helpers.CorsFilterHelper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;

@Component(property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/m/profile",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=agentProfile.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
}, service = Application.class)

public class AgentProfileAPI extends Application {

    private JwtKeyService _jwtKeyService;
    private static final Log _log = LogFactoryUtil.getLog(AgentProfileAPI.class);

    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into ProfileAPI");
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }

    /**
     * Get agent biodata for the authenticated user.
     */
    @Path("/biodata")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentBiodata(@HeaderParam("Authorization") String authHeader) {
        try {
            SecretKey key = _jwtKeyService.getKey();
            JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, key);

            if (!authResult.valid) {
                _log.warn("Unauthorized access: " + authResult.error);
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(JsonResponseHelper.error(authResult.error).toString())
                        .build();
            }

            // Fetch the agent/user from the authentication result
            MypageUser user = authResult.user;
            if (user == null) {
                _log.warn("Agent not found for token subject");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(JsonResponseHelper.error("Agent not found").toString())
                        .build();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String birthdate = user.getDob() != null ? sdf.format(user.getDob()) : "";
            String joinDate = user.getJoinDate() != null ? sdf.format(user.getJoinDate()) : "";

            // Convert DTO to JSONObject (utility method for reuse)
            JSONObject biodataJson = JSONFactoryUtil.createJSONObject();
            biodataJson.put("joinDate", joinDate);
            biodataJson.put("name", user.getUserName());
            biodataJson.put("address", user.getAddress());
            biodataJson.put("birthdate", birthdate);
            biodataJson.put("mobilePhone", user.getMobilePhone());
            biodataJson.put("phone", user.getPhone());
            biodataJson.put("email", user.getEmail());
            biodataJson.put("agentProfileImage", user.getProfileImageURL());
            biodataJson.put("agentBannerImage", user.getBannerImageURL());
            biodataJson.put("gender", user.getGender());
            biodataJson.put("profileUrl", user.getPrettyUrl());
            biodataJson.put("prettyUrlChange", user.getPrettyUrlChange());

            return Response.ok(JsonResponseHelper.success(biodataJson, "Biodata fetched successfully").toString())
                    .build();

        } catch (Exception e) {
            _log.error("Error in getAgentBiodata: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /*
     * update profile biodata
     */

    @Path("/biodata")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBiodata(
            @HeaderParam("Authorization") String authHeader,
            @Context HttpServletRequest httpServletRequest) {
        ServiceContext serviceContext;

        try {
            serviceContext = ServiceContextFactory.getInstance(httpServletRequest);
        } catch (Exception e) {
            _log.error("Failed to get ServiceContext", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Failed to get ServiceContext").toString())
                    .build();
        }

        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            // Check if request is multipart
            if (!ServletFileUpload.isMultipartContent(httpServletRequest)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Request is not multipart").toString())
                        .build();
            }
            // Prepare to handle file upload
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(10 * 1024); // 10 KB threshold in memory
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(50 * 1024 * 1024); // Max file size 50 MB
            upload.setSizeMax(100 * 1024 * 1024); // Max total request size 100 MB

            // Form parameters with default values from existing user data
            String name = user.getUserName();
            String address = user.getAddress();
            String gender = user.getGender();
            String mobilePhone = user.getMobilePhone();
            String email = user.getEmail();
            String phone = user.getPhone();
            String agentProfileImage = user.getProfileImageURL();
            String agentBannerImage = user.getBannerImageURL();
            String prettyUrl = user.getPrettyUrl();

            Long bannerFileEntry = user.getBannerImageFileEntryId();
            Long profileFileEntry = user.getProfileImageFileEntryId();
            String birthdateStr = user.getDob() != null ? new SimpleDateFormat("dd-MM-yyyy").format(user.getDob())
                    : null;

            // Variables for file uploads
            byte[] profileImageBytes = null;
            String profileImageContentType = null;
            String profileImageFileName = user.getMypageUserId() + "_profile_image";

            byte[] bannerImageBytes = null;
            String bannerImageContentType = null;
            String bannerImageFileName = user.getMypageUserId() + "_banner_image";

            List<FileItem> formItems = upload.parseRequest(httpServletRequest);

            for (FileItem item : formItems) {
                if (item.isFormField()) {
                    // Process regular form fields
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString("UTF-8");

                    switch (fieldName) {
                        case "name":
                            name = fieldValue;
                            break;
                        case "address":
                            address = fieldValue;
                            break;
                        case "gender":
                            gender = fieldValue;
                            break;
                        case "mobilePhone":
                            mobilePhone = fieldValue;
                            break;
                        case "email":
                            email = fieldValue;
                            break;
                        case "agentProfileImage":
                            // This is used when just passing the URL without uploading a new file
                            agentProfileImage = fieldValue;
                            break;
                        case "agentBannerImage":
                            // This is used when just passing the URL without uploading a new file
                            agentBannerImage = fieldValue;
                            break;
                        case "birthdate":
                            birthdateStr = fieldValue;
                            break;
                        case "phone":
                            phone = fieldValue;
                            break;
                        case "prettyUrl":
                            prettyUrl = fieldValue;
                            if (Validator.isNull(fieldValue)) {
                                return Response.status(Response.Status.BAD_REQUEST)
                                        .entity(JsonResponseHelper.error("Pretty URL cannot be empty").toString())
                                        .build();
                            }
                            user.setPrettyUrlChange(user.getPrettyUrlChange() + 1);
                            break;
                    }
                } else {
                    // Process file upload fields
                    if ("agentProfileImage".equals(item.getFieldName()) && item.getSize() > 0) {
                        profileImageFileName = new File(item.getName()).getName();
                        profileImageContentType = item.getContentType();

                        // Read the file content into a byte array
                        try (InputStream inputStream = item.getInputStream()) {
                            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                            int bytesRead;
                            byte[] data = new byte[1024];
                            while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                                buffer.write(data, 0, bytesRead);
                            }
                            buffer.flush();
                            profileImageBytes = buffer.toByteArray();
                        }

                    } else if ("agentBannerImage".equals(item.getFieldName()) && item.getSize() > 0) {
                        bannerImageFileName = new File(item.getName()).getName();
                        bannerImageContentType = item.getContentType();

                        // Read the file content into a byte array
                        try (InputStream inputStream = item.getInputStream()) {
                            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                            int bytesRead;
                            byte[] data = new byte[1024];
                            while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                                buffer.write(data, 0, bytesRead);
                            }
                            buffer.flush();
                            bannerImageBytes = buffer.toByteArray();
                        }

                    }
                }
            }

            // Process birthdate if provided
            if (Validator.isNotNull(birthdateStr)) {
                try {
                    Date birthdate = new SimpleDateFormat("dd-MM-yyyy").parse(birthdateStr);
                    user.setDob(birthdate);
                } catch (Exception ex) {
                    _log.warn("Invalid birthdate for user " + user.getMypageUserId() + ": " + birthdateStr);
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(JsonResponseHelper.error("Invalid birthdate format, expected dd-MM-yyyy")
                                    .toString())
                            .build();
                }
            }

            // Handle profile image upload if present
            if (profileImageBytes != null && profileImageBytes.length > 0) {

                try {
                    // Get the FileEntry using the stored fileEntryId and delete it
                    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(profileFileEntry);
                    if (fileEntry != null) {
                        DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
                    }
                } catch (NoSuchFileEntryException e) {
                    // File entry already deleted or not found, log and continue
                    _log.warn("File entry not found: " + user.getProfileImageFileEntryId(), e);
                } catch (Exception e) {
                    // Log error but continue with timeline deletion
                    _log.error("Error deleting image file: " + e.getMessage(), e);
                }

                Map<String, Object> uploadResult = imageWriter(
                        serviceContext,
                        profileImageBytes,
                        profileImageContentType,
                        user,
                        profileImageFileName,
                        "profile_images");

                if (uploadResult != null) {
                    agentProfileImage = (String) uploadResult.get("filePath");
                    profileFileEntry = (Long) uploadResult.get("fileEntryId");
                } else {
                    _log.error("Failed to upload profile image file");
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(JsonResponseHelper.error("Failed to upload profile image").toString())
                            .build();
                }
            }

            // Handle banner image upload if present
            if (bannerImageBytes != null && bannerImageBytes.length > 0) {

                try {
                    // Get the FileEntry using the stored fileEntryId and delete it
                    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(bannerFileEntry);
                    if (fileEntry != null) {
                        DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
                    }
                } catch (NoSuchFileEntryException e) {
                    // File entry already deleted or not found, log and continue
                    _log.warn("File entry not found: " + user.getBannerImageFileEntryId(), e);
                } catch (Exception e) {
                    // Log error but continue with timeline deletion
                    _log.error("Error deleting image file: " + e.getMessage(), e);
                }

                Map<String, Object> uploadResult = imageWriter(
                        serviceContext,
                        bannerImageBytes,
                        bannerImageContentType,
                        user,
                        bannerImageFileName,
                        "banner_images");

                if (uploadResult != null) {
                    agentBannerImage = (String) uploadResult.get("filePath");
                    bannerFileEntry = (Long) uploadResult.get("fileEntryId");
                } else {
                    _log.error("Failed to upload banner image file");
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(JsonResponseHelper.error("Failed to upload banner image").toString())
                            .build();
                }
            }

            // Update user data
            user.setProfileImageFileEntryId(profileFileEntry);
            user.setBannerImageFileEntryId(bannerFileEntry);
            user.setProfileImageURL(agentProfileImage);
            user.setBannerImageURL(agentBannerImage);
            user.setUserName(name);
            user.setAddress(address);
            user.setGender(gender);
            user.setMobilePhone(mobilePhone);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPrettyUrl(prettyUrl);
            user.persist();

            // Return updated data
            JSONObject updatedJson = JSONFactoryUtil.createJSONObject();
            updatedJson.put("name", user.getUserName());
            updatedJson.put("address", user.getAddress());
            updatedJson.put("gender", user.getGender());
            updatedJson.put("mobilePhone", user.getMobilePhone());
            updatedJson.put("email", user.getEmail());
            updatedJson.put("agentProfileImage", user.getProfileImageURL());
            updatedJson.put("birthdate",
                    user.getDob() != null ? new SimpleDateFormat("dd-MM-yyyy").format(user.getDob()) : "");
            updatedJson.put("agentBannerImage", user.getBannerImageURL());
            updatedJson.put("phone", user.getPhone());
            updatedJson.put("profileUrl", user.getPrettyUrl());
            return Response.ok(JsonResponseHelper.success(updatedJson, "Biodata updated successfully!").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error updating biodata: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Get agent working hours for the authenticated user.
     */
    @Path("/workinghours")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkingHours(@HeaderParam("Authorization") String authHeader) {
        try {
            SecretKey secretKey = _jwtKeyService.getKey();
            JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, secretKey);

            if (!authResult.valid) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(JsonResponseHelper.error(authResult.error).toString())
                        .build();
            }

            MypageUser user = authResult.user;
            long userId = user.getMypageUserId();
            if (userId <= 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Agent code not found").toString())
                        .build();
            }

            boolean is24Hours = user.getIs24Hours() == 1;

            // Fetch working hours from the database or service
            List<MypageUserWorkingHour> workingHours = com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil
                    .getByMypageUserId(userId);

            // Create the response object
            JSONObject responseJson = JSONFactoryUtil.createJSONObject();
            responseJson.put("is24Hours", is24Hours);

            JSONArray workingHoursArray = JSONFactoryUtil.createJSONArray();

            for (MypageUserWorkingHour workingHour : workingHours) {
                JSONObject hourJson = JSONFactoryUtil.createJSONObject();
                hourJson.put("day", workingHour.getDay());
                hourJson.put("startTime", workingHour.getStartTime());
                hourJson.put("endTime", workingHour.getEndTime());
                workingHoursArray.put(hourJson);
            }

            responseJson.put("workingHours", workingHoursArray);

            return Response
                    .ok(JsonResponseHelper.success(responseJson, "Working hours fetched successfully").toString())
                    .build();
        } catch (Exception e) {
            _log.error("Error fetching working hours: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Update agent working hours for the authenticated user.
     */
    @Path("/workinghours")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateWorkingHours(@HeaderParam("Authorization") String authHeader, String requestBody) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);

            boolean is24Hours = json.has("is24Hours") && json.getBoolean("is24Hours");
            user.setIs24Hours(is24Hours ? 1 : 0);

            JSONArray workingHoursArray = json.getJSONArray("workingHours");
            List<WorkingHourDto> workingHoursList = new ArrayList<>();
            for (int i = 0; i < workingHoursArray.length(); i++) {
                JSONObject whJson = workingHoursArray.getJSONObject(i);
                String day = whJson.getString("day");
                String startTime = whJson.getString("startTime");
                String endTime = whJson.getString("endTime");

                // Validate time format (simple HH:mm)
                if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
                    _log.warn(
                            "Invalid time format for working hour at index " + i + ": " + startTime + " - " + endTime);
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(JsonResponseHelper.error("Invalid time format at index " + i + ", expected HH:mm")
                                    .toString())
                            .build();
                }
                if (Validator.isNull(day)) {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(JsonResponseHelper.error("Day is required at index " + i).toString())
                            .build();
                }

                WorkingHourDto workingHourDto = new WorkingHourDto();
                workingHourDto.setDay(day);
                workingHourDto.setStartTime(startTime);
                workingHourDto.setEndTime(endTime);
                workingHoursList.add(workingHourDto);
            }

            // Atomic update
            try {
                MypageUserWorkingHourLocalServiceUtil.removeByMypageUserId(user.getMypageUserId());
                for (WorkingHourDto dto : workingHoursList) {
                    MypageUserWorkingHourLocalServiceUtil.addWorkingHour(
                            user.getMypageUserId(), dto.getDay(), dto.getStartTime(), dto.getEndTime(),
                            dto.getStatus());
                }
                user.persist();
            } catch (Exception ex) {
                _log.error("Error updating working hours for user " + user.getMypageUserId(), ex);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(JsonResponseHelper.error("Failed to update working hours").toString())
                        .build();
            }

            // Return updated data
            JSONObject updatedJson = JSONFactoryUtil.createJSONObject();
            updatedJson.put("is24Hours", is24Hours);
            JSONArray updatedArray = JSONFactoryUtil.createJSONArray();
            for (WorkingHourDto dto : workingHoursList) {
                JSONObject whJson = JSONFactoryUtil.createJSONObject();
                whJson.put("day", dto.getDay());
                whJson.put("startTime", dto.getStartTime());
                whJson.put("endTime", dto.getEndTime());
                updatedArray.put(whJson);
            }
            updatedJson.put("workingHours", updatedArray);

            return Response.ok(JsonResponseHelper.success(updatedJson, "Working hours updated successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error updating working hours: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Get agent location for the authenticated user.
     */
    @Path("/location")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentLocation(@HeaderParam("Authorization") String authHeader) {
        try {
            SecretKey key = _jwtKeyService.getKey();
            JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, key);

            if (!authResult.valid) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(JsonResponseHelper.error(authResult.error).toString())
                        .build();
            }

            String deptoreCode = authResult.claims.getSubject();
            if (deptoreCode == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(JsonResponseHelper.error("Agent not found").toString())
                        .build();
            }

            MypageUser user = authResult.user;

            // Get location from profileData
            String longitude = user.getLongitude();
            String latitude = user.getLatitude();
            String address = user.getAddress();
            // Create the response object
            JSONObject locationJson = JSONFactoryUtil.createJSONObject();
            locationJson.put("latitude", latitude);
            locationJson.put("longitude", longitude);
            locationJson.put("address", address);

            return Response.ok(JsonResponseHelper.success(locationJson, "Location fetched successfully").toString())
                    .build();
        } catch (Exception e) {
            _log.error("Error fetching agent location: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Update agent location for the authenticated user.
     */
    @Path("/location")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAgentLocation(@HeaderParam("Authorization") String authHeader, String requestBody) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);
            String latitude = json.getString("latitude", null);
            String longitude = json.getString("longitude", null);
            String address = json.getString("address", null);

            // Validate input
            if (Validator.isNull(latitude) || Validator.isNull(longitude) || Validator.isNull(address)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Latitude, longitude, and address are required.").toString())
                        .build();
            }
            try {
                Double.parseDouble(latitude);
                Double.parseDouble(longitude);
            } catch (NumberFormatException nfe) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Latitude and longitude must be valid numbers.").toString())
                        .build();
            }

            user.setLatitude(latitude);
            user.setLongitude(longitude);
            user.setAddress(address);
            user.persist();

            JSONObject updatedJson = JSONFactoryUtil.createJSONObject();
            updatedJson.put("latitude", user.getLatitude());
            updatedJson.put("longitude", user.getLongitude());
            updatedJson.put("address", user.getAddress());

            return Response.ok(JsonResponseHelper.success(updatedJson, "Location updated successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error updating agent location: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Get agent Social Media details for the authenticated user.
     */
    @Path("/socialmedia")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentSocialMedia(@HeaderParam("Authorization") String authHeader) {
        try {
            SecretKey key = _jwtKeyService.getKey();
            JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, key);

            if (!authResult.valid) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(JsonResponseHelper.error(authResult.error).toString())
                        .build();
            }

            MypageUser user = authResult.user;
            if (user == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(JsonResponseHelper.error("Agent not found").toString())
                        .build();
            }

            // Get social media details from profileData

            // Create the response object
            JSONObject socialMediaJson = JSONFactoryUtil.createJSONObject();
            socialMediaJson.put("facebook", user.getFacebook());
            socialMediaJson.put("twitter", user.getTwitter());
            socialMediaJson.put("instagram", user.getInstagram());
            socialMediaJson.put("tiktok", user.getTiktok());
            socialMediaJson.put("linkedIn", user.getLinkedIn());
            socialMediaJson.put("blog", user.getBlog());
            socialMediaJson.put("profileUrl", user.getPrettyUrl());

            return Response.ok(
                    JsonResponseHelper.success(socialMediaJson, "Social media details fetched successfully").toString())
                    .build();
        } catch (Exception e) {
            _log.error("Error fetching agent social media: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Update agent social media for the authenticated user.
     */
    @Path("/socialmedia")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAgentSocialMedia(@HeaderParam("Authorization") String authHeader, String requestBody) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);

            boolean hasAny = json.has("facebook") || json.has("twitter") || json.has("instagram")
                    || json.has("tiktok") || json.has("linkedIn") || json.has("blog");
            if (!hasAny) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("At least one social media field must be provided.")
                                .toString())
                        .build();
            }

            if (json.has("facebook"))
                user.setFacebook(json.getString("facebook"));
            if (json.has("twitter"))
                user.setTwitter(json.getString("twitter"));
            if (json.has("instagram"))
                user.setInstagram(json.getString("instagram"));
            if (json.has("tiktok"))
                user.setTiktok(json.getString("tiktok"));
            if (json.has("linkedIn"))
                user.setLinkedIn(json.getString("linkedIn"));
            if (json.has("blog"))
                user.setBlog(json.getString("blog"));
            user.persist();

            JSONObject updatedJson = JSONFactoryUtil.createJSONObject();
            updatedJson.put("facebook", user.getFacebook());
            updatedJson.put("twitter", user.getTwitter());
            updatedJson.put("instagram", user.getInstagram());
            updatedJson.put("tiktok", user.getTiktok());
            updatedJson.put("linkedIn", user.getLinkedIn());
            updatedJson.put("blog", user.getBlog());

            return Response.ok(JsonResponseHelper.success(updatedJson, "Social media updated successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error updating agent social media: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Update PaymentMethod
     */
    @Path("/otherconf")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOtherProfileConfiguration(@HeaderParam("Authorization") String authHeader,
            String requestBody) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);

            // Validate input
            if (Validator.isNull(json.getString("paymentMethod"))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Payment method is required.").toString())
                        .build();
            }

            String paymentMethod = json.getString("paymentMethod");
            user.setPaymentMethod(paymentMethod);
            user.persist();

            JSONObject updatedJson = JSONFactoryUtil.createJSONObject();
            updatedJson.put("paymentMethod", user.getPaymentMethod());

            return Response
                    .ok(JsonResponseHelper.success(updatedJson, "Payment method updated successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error updating agent social media: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }

    }

    /**
     * Get timeline list for the authenticated user.
     */
    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimelineList(@HeaderParam("Authorization") String authHeader) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            List<MypageUserTimeline> timelines = MypageUserTimelineLocalServiceUtil
                    .getByMypageUserId(user.getMypageUserId());

            JSONArray timelineArray = JSONFactoryUtil.createJSONArray();
            for (MypageUserTimeline timeline : timelines) {
                JSONObject obj = JSONFactoryUtil.createJSONObject();
                obj.put("timelineId", timeline.getMypageUserTimelineId());
                obj.put("text", timeline.getText());
                obj.put("createDate",
                        timeline.getCreateDate() != null
                                ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeline.getCreateDate())
                                : "");
                obj.put("userName", timeline.getUserName());
                obj.put("imgUrl", timeline.getImgUploadTimelineUrl());
                obj.put("videoUrl", timeline.getVideoUploadTimelineUrl());
                timelineArray.put(obj);
            }

            JSONObject result = JSONFactoryUtil.createJSONObject();
            result.put("timelines", timelineArray);

            return Response.ok(JsonResponseHelper.success(result, "Timeline list fetched successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error fetching timelines: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    /**
     * Create a new timeline entry for the authenticated user using base64 image in
     * JSON.
     */
    @POST
    @Path("/timeline")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTimeline(
            @HeaderParam("Authorization") String authHeader,
            @Context HttpServletRequest httpServletRequest) {
        ServiceContext serviceContext;
        try {
            serviceContext = ServiceContextFactory.getInstance(httpServletRequest);
        } catch (Exception e) {
            _log.error("timeline API createTimeline: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Failed to get ServiceContext").toString())
                    .build();
        }

        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);

            // Check if request is multipart
            if (!ServletFileUpload.isMultipartContent(httpServletRequest)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Request is not multipart").toString())
                        .build();
            }

            // Prepare to handle file upload
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(10 * 1024); // 10 KB threshold in memory
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(50 * 1024 * 1024); // Max file size 50 MB
            upload.setSizeMax(100 * 1024 * 1024); // Max total request size 100 MB

            // Form parameters
            String text = "";
            String videoUrl = "";
            String imageFileName = "timeline_image";
            byte[] imageBytes = null;
            String contentType = null;

            List<FileItem> formItems = upload.parseRequest(httpServletRequest);

            for (FileItem item : formItems) {

                if (item.isFormField()) {
                    // Process regular form fields
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString("UTF-8");

                    if ("text".equals(fieldName)) {
                        text = fieldValue;
                    } else if ("videoUrl".equals(fieldName)) {
                        videoUrl = fieldValue;
                    }
                } else {
                    // Process file upload field
                    if ("imageFile".equals(item.getFieldName()) && item.getSize() > 0) {
                        imageFileName = new File(item.getName()).getName();
                        contentType = item.getContentType();

                        // Read the file content into a byte array
                        try (InputStream inputStream = item.getInputStream()) {
                            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                            int bytesRead;
                            byte[] data = new byte[1024];
                            while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                                buffer.write(data, 0, bytesRead);
                            }
                            buffer.flush();
                            imageBytes = buffer.toByteArray();
                        }
                    }
                }
            }

            // Process the timeline creation
            String filePath = "";
            long fileEntryId = 0;

            // Handle image file if present
            if (imageBytes != null && imageBytes.length > 0) {
                try {

                    // Use the refactored uploader
                    Map<String, Object> uploadResult = imageWriter(
                            serviceContext,
                            imageBytes,
                            contentType,
                            user,
                            imageFileName,
                            "timeline_images");

                    if (uploadResult != null) {
                        fileEntryId = (Long) uploadResult.get("fileEntryId");
                        filePath = (String) uploadResult.get("filePath");
                    } else {
                        _log.error("Failed to upload image file");
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                .entity(JsonResponseHelper.error("Failed to upload image").toString())
                                .build();
                    }
                } catch (Exception e) {
                    _log.error("Error processing image: " + e.getMessage(), e);
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(JsonResponseHelper.error("Error processing image: " + e.getMessage()).toString())
                            .build();
                }
            }

            // Create timeline entry
            MypageUserTimeline timeline = MypageUserTimelineLocalServiceUtil.addTimeline(
                    user.getMypageUserId(),
                    text,
                    fileEntryId,
                    filePath,
                    videoUrl);

            // Create response JSON
            JSONObject responseJson = JSONFactoryUtil.createJSONObject();
            responseJson.put("timelineId", timeline.getMypageUserTimelineId());
            responseJson.put("text", timeline.getText());
            responseJson.put("imgUrl", timeline.getImgUploadTimelineUrl());
            responseJson.put("videoUrl", timeline.getVideoUploadTimelineUrl());
            responseJson.put("createDate",
                    timeline.getCreateDate() != null
                            ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeline.getCreateDate())
                            : "");

            return Response.ok(JsonResponseHelper.success(responseJson, "Timeline created successfully").toString())
                    .build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error creating timeline (multipart): " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    @DELETE
    @Path("/timeline/{timelineId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTimeline(
            @HeaderParam("Authorization") String authHeader,
            @PathParam("timelineId") long timelineId) {
        try {
            MypageUser user = JwtAuthHelper.getAuthenticatedUser(authHeader, _jwtKeyService);
            MypageUserTimeline timeline = MypageUserTimelineLocalServiceUtil.getMypageUserTimeline(timelineId);
            if (timeline == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(JsonResponseHelper.error("Timeline not found").toString())
                        .build();
            }
            if (timeline.getMypageUserId() != user.getMypageUserId()) {
                return Response.status(Response.Status.FORBIDDEN)
                        .entity(JsonResponseHelper.error("You do not have permission to delete this timeline")
                                .toString())
                        .build();
            }

            // If there's an image, delete the image file
            if (timeline.getImgUploadTimelineEntryId() > 0) {
                try {
                    // Get the FileEntry using the stored fileEntryId and delete it
                    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(timeline.getImgUploadTimelineEntryId());
                    if (fileEntry != null) {
                        DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
                    }
                } catch (NoSuchFileEntryException e) {
                    // File entry already deleted or not found, log and continue
                    _log.warn("File entry not found: " + timeline.getImgUploadTimelineEntryId(), e);
                } catch (Exception e) {
                    // Log error but continue with timeline deletion
                    _log.error("Error deleting image file: " + e.getMessage(), e);
                }
            }

            // Delete the timeline entry
            MypageUserTimelineLocalServiceUtil.deleteMypageUserTimeline(timeline);
            return Response.ok(JsonResponseHelper.success(null, "Timeline deleted successfully").toString()).build();
        } catch (WebApplicationException wae) {
            return wae.getResponse();
        } catch (Exception e) {
            _log.error("Error deleting timeline: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    private Map<String, Object> imageWriter(
            ServiceContext serviceContext,
            byte[] imageBytes,
            String contentType,
            MypageUser user,
            String fileName,
            String folderName) {

        Map<String, Object> result = new HashMap<>();

        try {
            // Validate file - using bytes.length is appropriate for file size validation
            _validateFile(fileName, contentType, imageBytes.length);

            long repositoryId = DLFolderConstants.getDataRepositoryId(
                    serviceContext.getScopeGroupId(),
                    DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

            // Get or create folder
            DLFolder folder = DLFolderLocalServiceUtil.fetchFolder(
                    serviceContext.getScopeGroupId(),
                    DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                    folderName);

            if (folder == null) {
                folder = DLFolderLocalServiceUtil.addFolder(
                        serviceContext.getUserId(),
                        serviceContext.getScopeGroupId(),
                        serviceContext.getScopeGroupId(),
                        false,
                        DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                        folderName,
                        "",
                        false,
                        serviceContext);
            }

            final DLFolder finalFolder = folder;

            // Set guest permissions on folder
            _setGuestPermission(serviceContext, DLFolder.class.getName(), finalFolder.getPrimaryKey());

            // Generate unique filename using UniqueFileNameProvider like in
            // AgentProfileMVCResourceCommand
            String uniqueFileName = _uniqueFileNameProvider.provide(fileName,
                    curFileName -> _exists(serviceContext.getScopeGroupId(), finalFolder.getFolderId(), curFileName));

            // Create temp file
            String tempDirectory = System.getProperty("java.io.tmpdir");
            File tmpFile = new File(tempDirectory + File.separator + uniqueFileName);

            try (FileOutputStream outputStream = new FileOutputStream(tmpFile)) {
                outputStream.write(imageBytes);
            }

            // Get MIME type if not provided
            String mimeType = contentType;
            if (Validator.isNull(mimeType)) {
                mimeType = MimeTypesUtil.getContentType(tmpFile);
            }

            // Add file entry using the unique filename
            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                    serviceContext.getUserId(),
                    repositoryId,
                    folder.getFolderId(),
                    uniqueFileName,
                    mimeType,
                    uniqueFileName,
                    "",
                    "",
                    tmpFile,
                    serviceContext);

            // Set guest permissions on file
            _setGuestPermission(serviceContext, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());

            // Clean up temp file
            if (!tmpFile.delete()) {
                _log.error("Failed to delete temporary file: " + tmpFile.getAbsolutePath());
            }


            // Get file path
            long fileEntryId = fileEntry.getFileEntryId();
            fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
            String filePath = "/documents/" + fileEntry.getGroupId() + "/" +
                    fileEntry.getFolderId() + "/" + fileEntry.getFileName();

            result.put("fileEntryId", fileEntryId);
            result.put("filePath", filePath);

            return result;

        } catch (Exception e) {
            _log.error("Error in imageWriter: " + e.getMessage(), e);
            return null;
        }
    }

    @POST
    @Path("/change-password")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePassword(
            @HeaderParam("X-App-Token") String app_token,
            String requestBody) {
        try {

            // extract the OTP and other parameters from the request body
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);

            String code = json.getString("Uid");
            String email = json.getString("Email");

            String otp = json.getString("Otp");
            String apiDecryptedData = json.getString("Csr");
            String newPassword = json.getString("Np");
            String confirmPassword = json.getString("Cn");
            String currentPassword = json.getString("Cp");

            // validate request body
            if (email == null || email.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Email is invalid!")).build();
            }
            if (code == null || code.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Code is invalid!"))
                        .build();
            }
            if (otp == null || otp.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Otp is invalid!"))
                        .build();
            }
            if (apiDecryptedData == null || apiDecryptedData.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Csr is invalid!"))
                        .build();
            }
            if (newPassword == null || newPassword.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("New password is invalid!")).build();
            }
            if (confirmPassword == null || confirmPassword.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Confirm password is invalid!")).build();
            }
            if (currentPassword == null || currentPassword.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Current password is invalid!")).build();
            }
            if (!newPassword.equals(confirmPassword)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("New password and confirm password do not match!")).build();
            }

            String endpoint = "/api/mapi/chgpas";

            JSONObject pimcoreRequestBody = JSONFactoryUtil.createJSONObject();
            pimcoreRequestBody.put("Uid", code);
            pimcoreRequestBody.put("Email", email);
            pimcoreRequestBody.put("Otp", otp);
            pimcoreRequestBody.put("Csr", apiDecryptedData);
            pimcoreRequestBody.put("Np", newPassword);
            pimcoreRequestBody.put("Cn", confirmPassword);
            pimcoreRequestBody.put("Cp", currentPassword);
            String pimcoreResponseStr = SendHttpRequestToPimcore.post(endpoint, pimcoreRequestBody.toString(),
                    app_token);
            JSONObject pimcoreResponse = JSONFactoryUtil.createJSONObject(pimcoreResponseStr);
            if (pimcoreResponse.getInt("Status") != 1) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error(pimcoreResponse.getString("Message"))).build();
            }

            String resData = pimcoreResponse.getString("Data");
            return Response.ok(JsonResponseHelper.success(resData, "Password changed!")).build();
        } catch (java.io.IOException e) {
            _log.error("Error Changing Password: " + e.getMessage(), e);
            String errorMessage = e.getMessage();

            if (errorMessage.contains("Unauthorized")) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(JsonResponseHelper.error("Pimcore-response : " + errorMessage)).build();
            } else if (errorMessage.contains("Forbidden")) {
                return Response.status(Response.Status.FORBIDDEN)
                        .entity(JsonResponseHelper.error("Pimcore-response : " + errorMessage)).build();
            } else if (errorMessage.contains("Bad Request")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Pimcore-response : " + errorMessage)).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(JsonResponseHelper.error("Pimcore-response : " + errorMessage)).build();
            }
        } catch (Exception e) {
            _log.error("Error in change password API: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Internal server error").toString())
                    .build();
        }
    }

    private boolean _exists(long groupId, long folderId, String curFileName) {
        try {
            FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(groupId, folderId,
                    curFileName);

            if (tempFileEntry != null) {
                return true;
            }

            return false;
        } catch (PortalException portalException) {
            if (_log.isDebugEnabled()) {
                _log.debug(portalException, portalException);
            }

            return false;
        }
    }

    private boolean _setGuestPermission(ServiceContext ServiceContext, String name, long primKey) {
        Map<Long, String[]> roleIdsToActionIds = new HashMap<>();
        roleIdsToActionIds.put(
                RoleLocalServiceUtil.fetchRole(ServiceContext.getCompanyId(), RoleConstants.GUEST).getRoleId(),
                new String[] { ActionKeys.VIEW });

        try {
            ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    ServiceContext.getCompanyId(), name,
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(primKey),
                    roleIdsToActionIds);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void _validateFile(String fileName, String contentType, long size) throws PortalException {

        long blogsImageMaxSize = _IMAGE_MAX_SIZE;

        if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
            throw new EntryImageSizeException();
        }

        Set<String> extensions = MimeTypesUtil.getExtensions(contentType);

        boolean validContentType = Stream.of(_IMAGE_EXTENSIONS)
                .anyMatch(extension -> extension.equals(StringPool.STAR) || extensions.contains(extension));

        if (!validContentType) {
            throw new EntryImageNameException("Invalid image for file name " + fileName);
        }
    }

    private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".png", ".jpg" };
    private static final long _IMAGE_MAX_SIZE = 5242880;

    @Reference
    private UniqueFileNameProvider _uniqueFileNameProvider;

}