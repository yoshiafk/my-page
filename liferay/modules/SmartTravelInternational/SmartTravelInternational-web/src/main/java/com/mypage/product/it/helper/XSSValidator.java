
package com.mypage.product.it.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

@SuppressWarnings("unchecked")
public class XSSValidator {

//    private static final PolicyFactory policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
//
//    public static void validatePayload(Map<String, Object> payload) {
//        List<String> detectedFields = new ArrayList<>();
//        validatePayload(payload, "", detectedFields);
//
//        if (!detectedFields.isEmpty()) {
//            throw new IllegalArgumentException("Potential XSS found in fields: " + String.join(", ", detectedFields));
//        }
//    }
//    
//    
//    private static boolean hasXSS(String value) {
//        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
//        Pattern emailPattern = Pattern.compile(emailRegex);
//
//        // Skip OWASP sanitization for valid emails
//        if (emailPattern.matcher(value).matches()) {
//            return false;
//        }
//
//        // Sanitize the input string using OWASP PolicyFactory
//        String sanitized = policyFactory.sanitize(value);
//
//        return !sanitized.equals(value);
//    }
//
//    private static void validatePayload(Map<String, Object> payload, String parentKey, List<String> detectedFields) {
//        payload.forEach((key, value) -> {
//            String currentKey = parentKey.isEmpty() ? key : parentKey + "." + key;
//
//            if (value instanceof String) {
//                if (hasXSS((String) value)) {
//                    detectedFields.add(currentKey);
//                }
//            } else if (value instanceof Map) {
//                validatePayload((Map<String, Object>) value, currentKey, detectedFields);
//            } else if (value instanceof Iterable) {
//                int index = 0;
//                for (Object item : (Iterable<Object>) value) {
//                    if (item instanceof String) {
//                        if (hasXSS((String) item)) {
//                            detectedFields.add(currentKey + "[" + index + "]");
//                        }
//                    } else if (item instanceof Map) {
//                        validatePayload((Map<String, Object>) item, currentKey + "[" + index + "]", detectedFields);
//                    }
//                    index++;
//                }
//            }
//        });
//    }
	
	
	private static final PolicyFactory policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

	public static Map<String, Object> sanitizePayload(Map<String, Object> payload) {
	    return sanitizePayload(payload, "");
	}

	private static Map<String, Object> sanitizePayload(Map<String, Object> payload, String parentKey) {
	    Map<String, Object> sanitizedPayload = new HashMap<>();

	    payload.forEach((key, value) -> {
	        String currentKey = parentKey.isEmpty() ? key : parentKey + "." + key;

	        // Skip sanitization for specific keys
	        if (key.equals("_fotoktp") || key.equals("token") || key.equals("_dob")) {
	            sanitizedPayload.put(key, value);
	        }  else if (value instanceof String) {
	            // Sanitize the string
	            String sanitizedValue = sanitizeValue((String) value);
	            sanitizedPayload.put(key, sanitizedValue);
	        } else if (value instanceof Map) {
	            // Recursively sanitize nested Map
	            sanitizedPayload.put(key, sanitizePayload((Map<String, Object>) value, currentKey));
	        } else if (value instanceof Iterable) {
	            // Handle lists or arrays
	            List<Object> sanitizedList = new ArrayList<>();
	            int index = 0;
	            for (Object item : (Iterable<Object>) value) {
	                if (item instanceof String) {
	                    sanitizedList.add(sanitizeValue((String) item));
	                } else if (item instanceof Map) {
	                    sanitizedList.add(sanitizePayload((Map<String, Object>) item, currentKey + "[" + index + "]"));
	                } else {
	                    sanitizedList.add(item); // Preserve other types as is
	                }
	                index++;
	            }
	            sanitizedPayload.put(key, sanitizedList);
	        } else {
	            sanitizedPayload.put(key, value); // Preserve other types as is
	        }
	    });

	    return sanitizedPayload;
	}
	
	private static String sanitizeValue(String value) {
        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Skip sanitization for valid emails
        if (emailPattern.matcher(value).matches()) {
            return value;
        }

        // Sanitize the input string
        String sanitizedValue = policyFactory.sanitize(value);

        // Decode HTML entities (e.g., &#039; back to ')
        sanitizedValue = sanitizedValue.replace("&#39;", "'").replace("&#039;", "'");

        return sanitizedValue;
    }

    
}

