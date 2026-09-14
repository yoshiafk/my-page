package com.mypage.agencyportal.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class SendHttpRequestToPimcore {
    
    private static final ActionHelpers helpers = new ActionHelpers();

    private static final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress"); // untuk api

    public static String post(String endpoint, String jsonBody, String app_token) throws IOException {
        URL obj = new URL(PIMCORE_ADDRESS + endpoint);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        // con.setRequestProperty("Authorization", mobile_token);
        con.setRequestProperty("X-App-Token", app_token);
        con.setDoOutput(true);



        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        BufferedReader in;

        if (responseCode != HttpURLConnection.HTTP_OK) {
            // Read the error stream to get the API's error message
            in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
            StringBuilder errorResponse = new StringBuilder();
            String line;
    
            while ((line = in.readLine()) != null) {
                errorResponse.append(line);
            }
            in.close();
            
            // Extract the "Message" field from the error response (assuming it's JSON)
            String errorMessage = "Error: " + httpStatusCodeHelper(responseCode);
            try {
                System.out.println("Error response: " + errorResponse.toString());
                JSONObject errorJson = JSONFactoryUtil.createJSONObject(errorResponse.toString());
                if (errorJson.has("Message")) {
                    errorMessage = errorJson.getString("Message");
                }
            } catch (Exception e) {
                // If parsing fails, fallback to the raw error response
                errorMessage = errorResponse.toString();
            }
            throw new IOException(errorMessage);
        } else {
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        }
    
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }

    
    private static String httpStatusCodeHelper(int statusCode){
        String response = "Uncaught Error";
        switch (statusCode) {
            case 401:
                response = "Unauthorized";
                break;
            case 400:
                response = "Bad Request";
                break;
            case 403:
                response = "Forbidden";
                break;
        }
        return response;
    }

}
