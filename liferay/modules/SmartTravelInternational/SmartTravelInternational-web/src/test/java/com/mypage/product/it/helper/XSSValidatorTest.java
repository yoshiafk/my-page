package com.mypage.product.it.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XSSValidatorTest {
	
	private XSSValidator service;
	
	@BeforeEach
    void setUp() {
        service = new XSSValidator();
    }
	
	private String callSanitizeValue(String input) throws Exception {
        Method method = XSSValidator.class.getDeclaredMethod("sanitizeValue", String.class);
        method.setAccessible(true);
        return (String) method.invoke(service, input);
    }

	@Test
    void testSanitizePayload_skipSpecificKeys() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("_fotoktp", "<script>alert('x')</script>");
        payload.put("token", "<b>abc</b>");
        payload.put("_dob", "<i>xyz</i>");

        Map<String, Object> sanitized = XSSValidator.sanitizePayload(payload);

        assertEquals("<script>alert('x')</script>", sanitized.get("_fotoktp"));
        assertEquals("<b>abc</b>", sanitized.get("token"));
        assertEquals("<i>xyz</i>", sanitized.get("_dob"));
    }

    @Test
    void testSanitizePayload_sanitizeSimpleString() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "<script>alert('x')</script>");
        payload.put("city", "Bandung");

        Map<String, Object> sanitized = XSSValidator.sanitizePayload(payload);

        // Script tag harus hilang
        assertFalse(((String) sanitized.get("name")).contains("<script>"));
        assertEquals("Bandung", sanitized.get("city"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testSanitizePayload_nestedMap() {
        Map<String, Object> nested = new HashMap<>();
        nested.put("comment", "<b>Hello</b><script>alert(1)</script>");

        Map<String, Object> payload = new HashMap<>();
        payload.put("user", nested);

        Map<String, Object> sanitized = XSSValidator.sanitizePayload(payload);

        Map<String, Object> sanitizedNested = (Map<String, Object>) sanitized.get("user");
        String result = (String) sanitizedNested.get("comment");

        assertTrue(result.contains("<b>Hello</b>"));
        assertFalse(result.contains("<script>"));
    }

    @SuppressWarnings("unchecked")
    @Test
    void testSanitizePayload_listOfValues() {
        List<Object> items = new ArrayList<>();
        items.add("<i>valid</i>");
        items.add("<script>x</script>");
        Map<String, Object> payload = new HashMap<>();
        payload.put("list", items);

        Map<String, Object> sanitized = XSSValidator.sanitizePayload(payload);

        List<Object> sanitizedList = (List<Object>) sanitized.get("list");
        assertTrue(((String) sanitizedList.get(0)).contains("<i>valid</i>"));
        assertFalse(((String) sanitizedList.get(1)).contains("<script>"));
    }

    @Test
    void testSanitizeValue_emailShouldNotBeSanitized() throws Exception {
        String email = "test.user@example.com";
        String result = callSanitizeValue(email);
        assertEquals(email, result);
    }

    @Test
    void testSanitizeValue_htmlShouldBeSanitized() throws Exception {
        String dirty = "<script>alert('x')</script>";
        String result = callSanitizeValue(dirty);
        assertFalse(result.contains("<script>"));
        assertTrue(result.isEmpty());
    }

    @Test
    void testSanitizeValue_htmlEntityShouldBeDecoded() throws Exception {
        String dirty = "O&#039;Reilly";
        String result = callSanitizeValue(dirty);
        assertEquals("O'Reilly", result);
    }
}
