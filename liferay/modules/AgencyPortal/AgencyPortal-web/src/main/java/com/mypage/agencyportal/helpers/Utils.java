package com.mypage.agencyportal.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Utils {
	
	public Map<String, String> getQueryParameters(String url) throws URISyntaxException, UnsupportedEncodingException {
        Map<String, String> parameters = new HashMap<>();
        URI uri = new URI(url);
        String query = uri.getQuery();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                try {
                    String[] keyValue = pair.split("=");
                    String key = keyValue[0];
                    String value = (keyValue.length > 1) ? keyValue[1] : "";
                    parameters.put(key, URLDecoder.decode(value, "UTF-8"));
                } catch (UnsupportedEncodingException | ArrayIndexOutOfBoundsException e) {
        			System.out.println(e.getMessage());
                }
            }
        }
        return parameters;
    }
	
}
