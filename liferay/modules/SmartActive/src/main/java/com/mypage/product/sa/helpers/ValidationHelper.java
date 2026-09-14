package com.mypage.product.sa.helpers;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil;
import com.mypage.product.sa.portlet.SmartActivePortlet;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidationHelper {

	private static final Map<String, String> fieldValidationRules = new HashMap<>();
	
	static {
        fieldValidationRules.put("name", "text");
        fieldValidationRules.put("citizenship", "citizenship");
        fieldValidationRules.put("idNum", "num");
        fieldValidationRules.put("dob", "date");
        fieldValidationRules.put("pob", "text");
        fieldValidationRules.put("gender", "text");
        fieldValidationRules.put("phoneNumber", "phone");
        fieldValidationRules.put("email", "email");
        fieldValidationRules.put("zip", "num");
        fieldValidationRules.put("province", "text");
        fieldValidationRules.put("city", "text");
        fieldValidationRules.put("address", "addr");
        fieldValidationRules.put("job", "job");
        fieldValidationRules.put("worklocation", "text");
        fieldValidationRules.put("additionalworklocation", "text");
        fieldValidationRules.put("monthlyincome", "income");
        fieldValidationRules.put("paymentsource", "text");
        fieldValidationRules.put("additionalpaymentsource", "text");
        fieldValidationRules.put("startdate", "date");
        fieldValidationRules.put("expireddate", "date");
        fieldValidationRules.put("mainbenefitvalue", "num");
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
            case "phone":
                pattern = Pattern.compile("^\\+62[0-9]{11,12}$");
                return pattern.matcher(value).matches();
            case "num":
                pattern = Pattern.compile("^[0-9]+$");
                return pattern.matcher(value).matches();
            case "textnum":
                pattern = Pattern.compile("^[A-Za-z0-9]+$");
                return pattern.matcher(value).matches();
            case "email":
            	pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                return pattern.matcher(value).matches();
            case "addr":
                pattern = Pattern.compile("^[A-Za-z0-9.,/ \\-]+$");
                return pattern.matcher(value).matches();
            case "income":
                pattern = Pattern.compile("^[A-Za-z0-9<>. \\-]+$"); // Allows letters, numbers, `<`, `>`, `-`, `.`
                return pattern.matcher(value).matches();
            case "job":
                pattern = Pattern.compile("^[A-Za-z&,\\-(). ]+$");
                return pattern.matcher(value).matches();
            case "date":
                return validateDate(value, "dd/MMM/yyyy"); // Validate date format
            case "decimal":
            	pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
                return pattern.matcher(value).matches();
            case "currency":
                return validateCurrency(value);
            case "citizenship":
                pattern = Pattern.compile("^[A-Za-z',() ]+$");
                return pattern.matcher(value).matches();
            default:
                return false;
        }
    }
	
	public static boolean validateDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("id", "ID"));

        try {
            Date date = sdf.parse(dateStr.replace("Agt", "Agu"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	public static String validateJob(String idJob) {
		List<SmartActiveOccupation> occupations = SmartActiveOccupationLocalServiceUtil.getActiveOccupation();
		SmartActiveOccupation targetOccupation = occupations.stream()
												 .filter(o -> o.getSmartActiveOccupationId() == Long.valueOf(idJob))
												 .findFirst().orElse(null);
		
		return targetOccupation.getNameId();
    }
	
	public static boolean validateCurrency(String code) {
	    try {
	        Currency.getInstance(code.toUpperCase());
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public boolean validateJSON(JSONObject params) {
        if (params == null) {
            return false;
        }

        JSONObject kyc = Validator.isNull(params.getJSONObject("kyc")) == true ? params : params.getJSONObject("kyc");
        
        if (kyc == null) {
            return false;
        }

        Iterator<String> keys = kyc.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = kyc.getString(key);
            if (key.equalsIgnoreCase("job") && value.matches("\\d+")) value = validateJob(value);

            if (fieldValidationRules.containsKey(key.toLowerCase())) {
                String expectedType = fieldValidationRules.get(key.toLowerCase());
                if (Validator.isNull(value)) {
                	_log.info(key + " " + value);
                	return false;
                }
                if (!validateInput(value, expectedType)) {
                	_log.info(key + " " + value + " " + expectedType);
                    return false;
                }
            }
        }

        return true;
    }
	
	private static Log _log = LogFactoryUtil.getLog(ValidationHelper.class);
}
