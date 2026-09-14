package com.mypage.agencyportal.helpers;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class JsonResponseHelper {

    public static String success(Object data, String message) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        String finalMessage = (message != null && !message.trim().isEmpty()) ? message : "Success";
        response.put("status", 1);
        response.put("message", finalMessage);
        response.put("data", data);
        return response.toString();
    }

    public static String error(String message) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put("status", 0);
        response.put("message", message);
        response.put("data", JSONFactoryUtil.createJSONObject());
        return response.toString();
    }
}