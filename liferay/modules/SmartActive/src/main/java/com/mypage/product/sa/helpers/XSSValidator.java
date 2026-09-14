
package com.mypage.product.sa.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

@SuppressWarnings("unchecked")
public class XSSValidator {
	
	private static final PolicyFactory policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
	
	public String sanitizeHtml(String input) {
		PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
		
        return policy.sanitize(input);
    }

	public static Map<String, Object> sanitizePayload(Map<String, Object> payload) {
	    return sanitizePayload(payload, "");
	}

	private static Map<String, Object> sanitizePayload(Map<String, Object> payload, String parentKey) {
	    Map<String, Object> sanitizedPayload = new HashMap<>();

	    payload.forEach((key, value) -> {
	        String currentKey = parentKey.isEmpty() ? key : parentKey + "." + key;

	        // Skip sanitization for specific keys termasuk tanggal mengandung garis miring eg: 12/Feb/1995
	        if (key.equals("token") || key.equals("Token") || key.equals("Dob") || key.equals("StartDate") || key.equals("ExpiredDate") || key.equals("PeriodeFrom") || key.equals("PeriodeTo") || key.equals("ImageId") || key.equals("PhotoFileUrl") || key.equals("TokenLimiter") || key.equals("PhoneNumber")) {
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

