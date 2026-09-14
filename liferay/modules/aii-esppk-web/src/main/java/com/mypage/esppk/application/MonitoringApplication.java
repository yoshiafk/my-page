package com.mypage.esppk.application;

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.SppkDebiturLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.esppk.helper.ActionHelper;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.helper.ValidationAuthHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/sppk/monitoring",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=MonitoringApplication.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class MonitoringApplication extends Application {
    private static final Log log = LogFactoryUtil.getLog(MonitoringApplication.class);

    private JSONArray buildSortArray(JSONObject params) {
        JSONArray sortArray = JSONFactoryUtil.createJSONArray();

        for (int i = 0; i < params.getJSONArray("order").length(); i++) {
            JSONObject orderObj = params.getJSONArray("order").getJSONObject(i);

            int colIndex = orderObj.getInt("column");
            String sortDir = orderObj.getString("dir");
            String columnName = params.getJSONArray("columns").getJSONObject(colIndex).getString("data");

            JSONObject sortItem = JSONFactoryUtil.createJSONObject();
            sortItem.put("column", columnName);
            sortItem.put("direction", sortDir);

            sortArray.put(sortItem);
        }

        return sortArray;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAction(String request, @Context HttpServletRequest httpServletRequest) throws JSONException {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        JSONObject params = JSONFactoryUtil.createJSONObject(request);
        ActionHelper helper = new ActionHelper();

        Optional<Response> errorResponse = validationAuthHelper.validateJwtAndCsrf(httpServletRequest, "accessMonitoring");

        if (errorResponse.isPresent()) {
            return errorResponse.get();
        }

        int draw = params.getInt("draw");
        int startFilter = params.getInt("start");
        int lengthFilter = params.getInt("length");

        JSONObject paramFilter = JSONFactoryUtil.createJSONObject();
        paramFilter.put("fullName", params.getString("fullNameFilter"));
        paramFilter.put("idNumber", params.getString("idNumberFilter"));
        paramFilter.put("birthDate", params.getString("birthDateFilter"));
        paramFilter.put(STATUS, params.getString("statusFilter"));
        paramFilter.put("submitEsppkDate", params.getString("submitEsppkDateFilter"));
        paramFilter.put("applicationNumber", params.getString("applicationNumberFilter"));
        paramFilter.put("submissionNumber", params.getString("submissionNumberFilter"));

        JSONArray sortArray = buildSortArray(params);
        JSONArray dataArray = JSONFactoryUtil.createJSONArray();

        try {
            int totalRecords = SppkDebiturLocalServiceUtil.countTotalSppkDebiturSubmitted();

            int filteredRecords = SppkDebiturLocalServiceUtil.countFilterMonitoring(paramFilter);

            int end = Math.min(startFilter + lengthFilter, filteredRecords);

            List<SppkDebitur> resultFilter = SppkDebiturLocalServiceUtil.filterMonitoring(paramFilter, startFilter, end, sortArray);
            if (Validator.isNotNull(resultFilter)) {
                for (SppkDebitur item : resultFilter) {
                    JSONObject row = JSONFactoryUtil.createJSONObject();
                    row.put("submitEsppkDate", item.getSubmitEsppkDate());
                    row.put("submissionNumber", item.getSubmissionNumber());
                    row.put(STATUS, helper.statusDebitur(item.getEsppkQ1(), item.getEsppkQ2(), item.getEsppkQ3()));
                    row.put("fullName", item.getFullName());
                    row.put("idNumber", item.getIdNumber());
                    row.put("gender", item.getGender());
                    row.put("birthDate", item.getBirthDate());
                    row.put("phoneNumber", item.getPhoneNumber());
                    row.put("email", item.getEmail());
                    row.put("address", item.getAddress());
                    row.put("sumInsured", item.getSumInsured());
                    row.put("occupation", item.getOccupation());
                    row.put("product", item.getProduct());
                    row.put("applicationNumber", item.getApplicationNumber());
                    row.put("target", EncryptionHelper.encrypt(String.valueOf(item.getSppkDebiturId())));
                    dataArray.put(row);
                }
            }

            response.put("draw", draw);
            response.put("recordsTotal", totalRecords);
            response.put("recordsFiltered", filteredRecords);
            response.put("data", dataArray);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return Response.ok(response.toString()).build();
    }

    private static final String STATUS = "status";

    @Reference(unbind = "-")
    private ValidationAuthHelper validationAuthHelper;
}
