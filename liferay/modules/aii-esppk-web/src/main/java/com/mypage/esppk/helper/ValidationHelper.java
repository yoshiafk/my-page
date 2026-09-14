package com.mypage.esppk.helper;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ValidationHelper {
    private static final Map<String, String> fieldValidationRules = new HashMap<>();

    static {
        fieldValidationRules.put("name", "text");
        fieldValidationRules.put("idNumber", "num");
//        fieldValidationRules.put("address", "addr");
        fieldValidationRules.put("birthDateAlt", "date");
        fieldValidationRules.put("birthPlace", "place");
        String gender = "gender";
        fieldValidationRules.put(gender, gender);
        fieldValidationRules.put("phoneNumber", "phone");
        String email = "email";
        fieldValidationRules.put(email, email);
        fieldValidationRules.put("occupation", "job");
        fieldValidationRules.put("sumInsured", "currency");
        fieldValidationRules.put("product", "text");
    }

    public static boolean validateInput(String value, String type) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        Pattern pattern;
        switch (type.toLowerCase()) {
            case "text":
                pattern = Pattern.compile("^[A-Za-z ]+$");
                return pattern.matcher(value).matches();
            case "place":
                pattern = Pattern.compile("^[A-Za-z.'\\- ]+$");
                return pattern.matcher(value).matches();
            case "phone":
                pattern = Pattern.compile("^08[\\d]{10,11}$");
                return pattern.matcher(value).matches();
            case "num":
                pattern = Pattern.compile("^[\\d]+$");
                return pattern.matcher(value).matches();
            case "currency":
                pattern = Pattern.compile("^[\\d.]+$");
                return pattern.matcher(value).matches();
            case "email":
                pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                return pattern.matcher(value).matches();
            case "job":
                pattern = Pattern.compile("^[A-Za-z/]+$");
                return pattern.matcher(value).matches();
            case "date":
                return validateDate(value, "yyyy/MM/dd"); // Validate date format
            case "gender":
                pattern = Pattern.compile("^[A-Za-z\\-]+$");
                return pattern.matcher(value).matches();
            case "addr":
                pattern = Pattern.compile("^[A-Za-z0-9.,/ \\-]+$");
                return pattern.matcher(value).matches();
            default:
                return false;
        }
    }

    public static boolean validateDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            sdf.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateJSON(JSONObject params) {
        if (params == null) {
            return false;
        }

        Iterator<String> keys = params.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = params.getString(key);

            if (fieldValidationRules.containsKey(key.toLowerCase())) {
                String expectedType = fieldValidationRules.get(key.toLowerCase());
                if (Validator.isNull(value)) {
                    log.info(key + " " + value);
                    return false;
                }
                if (!validateInput(value, expectedType)) {
                    log.info(key + " " + value + " " + expectedType);
                    return false;
                }
            }
        }

        return true;
    }

    private static final Log log = LogFactoryUtil.getLog(ValidationHelper.class);
}
