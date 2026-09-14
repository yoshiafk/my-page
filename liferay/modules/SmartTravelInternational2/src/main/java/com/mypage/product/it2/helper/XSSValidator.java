package com.mypage.product.it2.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

@SuppressWarnings("unchecked")
public class XSSValidator {

    private XSSValidator() {
        throw new IllegalStateException("Utility class");
    }

    private static final PolicyFactory policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    public static Map<String, Object> sanitizePayload(Map<String, Object> payload) {
        return sanitizePayload(payload, "");
    }

    private static Map<String, Object> sanitizePayload(Map<String, Object> payload, String parentKey) {
        Map<String, Object> sanitizedPayload = new HashMap<>();

        payload.forEach((key, value) -> sanitizedPayload.put(
                key, sanitizeEntry(key, value, parentKey)
        ));

        return sanitizedPayload;
    }

    private static Object sanitizeEntry(String key, Object value, String parentKey) {
        String currentKey = parentKey.isEmpty() ? key : parentKey + "." + key;

        if (shouldSkipSanitization(key)) {
            return value;
        }

        if (value instanceof String) {
            return sanitizeValue((String) value);
        }

        if (value instanceof Map) {
            return sanitizePayload((Map<String, Object>) value, currentKey);
        }

        if (value instanceof Iterable) {
            return sanitizeList((Iterable<?>) value, currentKey);
        }

        return value;
    }

    private static boolean shouldSkipSanitization(String key) {
        return "_fotoktp".equals(key) || "token".equals(key) || "_dob".equals(key);
    }

    private static List<Object> sanitizeList(Iterable<?> items, String parentKey) {
        List<Object> sanitizedList = new ArrayList<>();
        int index = 0;

        for (Object item : items) {
            if (item instanceof String) {
                sanitizedList.add(sanitizeValue((String) item));
            } else if (item instanceof Map) {
                sanitizedList.add(sanitizePayload(
                        (Map<String, Object>) item, parentKey + "[" + index + "]"
                ));
            } else {
                sanitizedList.add(item);
            }
            index++;
        }

        return sanitizedList;
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
