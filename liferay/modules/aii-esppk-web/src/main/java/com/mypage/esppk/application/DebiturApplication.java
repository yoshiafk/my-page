package com.mypage.esppk.application;

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.SppkDebiturLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mypage.esppk.helper.ActionHelper;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.helper.ValidationAuthHelper;
import com.mypage.esppk.util.MaskingUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/sppk/debitur",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=DebiturApplication.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
public class DebiturApplication extends Application {
    private static final Log log = LogFactoryUtil.getLog(DebiturApplication.class);
    private static final String FULLNAME = "fullName";
    private static final String CREATE_DATE = "createDate";
    private static final String ID_NUMBER = "idNumber";
    private static final String APPLICATION_NUMBER = "applicationNumber";
    private static final String SUBMISSION_NUMBER = "submissionNumber";

    @Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAction(String request, @Context HttpServletRequest httpServletRequest)
            throws PortalException {

		JSONObject params = JSONFactoryUtil.createJSONObject(request);
        int draw = params.getInt("draw");

        Optional<Response> errorResponse = validationAuthHelper.validateJwtAndCsrf(httpServletRequest, "accessData");

        if (errorResponse.isPresent()) {
            return errorResponse.get();
        }

        JSONObject paramFilter = buildParamFilter(params);

        if (shouldReturnEmpty(params, paramFilter) || isOnlyDateFilled(paramFilter)) {
            return Response.ok(buildEmptyResponse(draw).toString()).build();
        }

        int startFilter = params.getInt("start");
        int lengthFilter = params.getInt("length");

        JSONArray sortArray = buildSortArray(params);
        JSONArray dataArray = fetchFilteredData(paramFilter, startFilter, lengthFilter, sortArray);

        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put("draw", draw);
        response.put("recordsTotal", SppkDebiturLocalServiceUtil.countTotalSppkDebitur());
        response.put("recordsFiltered", SppkDebiturLocalServiceUtil.countFilterDebitur(paramFilter));
        response.put("data", dataArray);
		
		return Response.ok(response.toString()).build();
	}

    private JSONObject buildParamFilter(JSONObject params) {
        JSONObject paramFilter = JSONFactoryUtil.createJSONObject();

        paramFilter.put(FULLNAME, params.getString("fullNameFilter"));
        paramFilter.put(ID_NUMBER, params.getString("idNumberFilter"));
        paramFilter.put(CREATE_DATE, params.getString("createDateFilter"));
        paramFilter.put(APPLICATION_NUMBER, params.getString("applicationNumberFilter"));
        paramFilter.put(SUBMISSION_NUMBER, params.getString("submissionNumberFilter"));

        return paramFilter;
    }

    private boolean shouldReturnEmpty(JSONObject params, JSONObject filter) {
        boolean allEmpty = filter.keySet().stream()
                .map(filter::getString)
                .allMatch(v -> v == null || v.trim().isEmpty());

        return (params.has("_noLoad") && params.getBoolean("_noLoad")) || allEmpty;
    }

    private boolean isOnlyDateFilled(JSONObject filter) {
        String date = filter.getString(CREATE_DATE);
        boolean dateFilled = date != null && !date.trim().isEmpty();

        String fullName = filter.getString(FULLNAME);
        String idNumber = filter.getString(ID_NUMBER);
        String applicationNumber = filter.getString(APPLICATION_NUMBER);
        String submissionNumber = filter.getString(SUBMISSION_NUMBER);

        boolean othersEmpty =
            fullName.trim().isEmpty() &&
            idNumber.trim().isEmpty() &&
            applicationNumber.trim().isEmpty() &&
            submissionNumber.trim().isEmpty();

        return dateFilled && othersEmpty;
    }

    private JSONObject buildEmptyResponse(int draw) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put("draw", draw);
        response.put("recordsTotal", 0);
        response.put("recordsFiltered", 0);
        response.put("data", JSONFactoryUtil.createJSONArray());
        return response;
    }

    private JSONArray buildSortArray(JSONObject params) {
        JSONArray orderArray = params.getJSONArray("order");
        JSONArray columnsArray = params.getJSONArray("columns");
        JSONArray sortArray = JSONFactoryUtil.createJSONArray();

        for (int i = 0; i < orderArray.length(); i++) {
            JSONObject orderObj = orderArray.getJSONObject(i);

            int colIndex = orderObj.getInt("column");
            String sortDir = orderObj.getString("dir");
            String columnName = columnsArray.getJSONObject(colIndex).getString("data");

            JSONObject sortItem = JSONFactoryUtil.createJSONObject();
            sortItem.put("column", columnName);
            sortItem.put("direction", sortDir);

            sortArray.put(sortItem);
        }

        return sortArray;
    }

    private JSONArray fetchFilteredData(JSONObject filter, int start, int length, JSONArray sortArray) {
        JSONArray dataArray = JSONFactoryUtil.createJSONArray();

        try {
            int filteredRecords = SppkDebiturLocalServiceUtil.countFilterDebitur(filter);
            int end = Math.min(start + length, filteredRecords);

            List<SppkDebitur> result = SppkDebiturLocalServiceUtil.filterDebitur(filter, start, end, sortArray);

            if (Validator.isNotNull(result)) {
                for (SppkDebitur item : result) {
                    dataArray.put(buildRow(item));
                }
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return dataArray;
    }

    private JSONObject buildRow(SppkDebitur item) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        ActionHelper helper = new ActionHelper();
        JSONObject row = JSONFactoryUtil.createJSONObject();

        row.put(CREATE_DATE, item.getCreateDate());
        row.put(SUBMISSION_NUMBER, item.getSubmissionNumber());
        row.put("status", item.getSubmitEsppkDate() == null ? "" : helper.statusDebitur(item.getEsppkQ1(), item.getEsppkQ2(), item.getEsppkQ3()));
        row.put(FULLNAME, item.getFullName());
        row.put(ID_NUMBER, MaskingUtil.maskNik(item.getIdNumber()));
        row.put("phoneNumber", MaskingUtil.maskPhone(item.getPhoneNumber()));
        row.put("email", MaskingUtil.maskEmail(item.getEmail()));
        row.put("sumInsured", item.getSumInsured());
        row.put("product", item.getProduct());
        row.put(APPLICATION_NUMBER, item.getApplicationNumber());
        row.put("did", EncryptionHelper.encrypt(String.valueOf(item.getSppkDebiturId())));
        row.put("isSubmittedSppk", item.getSubmitEsppkDate() == null ? 0 : 1);

        return row;
    }

    @Reference(unbind = "-")
    private ValidationAuthHelper validationAuthHelper;
}
