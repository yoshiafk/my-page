package com.mypage.product.it2.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class MypageHelpers {

    public String getOcrClientHostURL() {
        return getConfig("com.mypage.agent.config.ocrClientHostURL");
    }

    public String getOcrClientPathURL() {
        return getConfig("com.mypage.agent.config.ocrClientPathURL");
    }

    public String getOcrClientApiKey() {
        return getConfig("com.mypage.agent.config.ocrClientApiKey");
    }

    public String getOcrClientAuthHeader() {
        return getConfig("com.mypage.agent.config.ocrClientAuthHeader");
    }

    public String getPimcoreHost() {
        return getConfig("com.mypage.agent.config.pimcoreHost");
    }

    public String getPimcoreAddress() {
        return getConfig("com.mypage.agent.config.pimcoreAddress");
    }

    public String getApiPayment() {
        return getConfig("smarttravel.api.payment");
    }

    public String getApiCreateQuote() {
        return getConfig("smarttravel.api.leads.createQuote");
    }

    public String getApiCheckPromoCode() {
        return getConfig("smarttravel.api.leads.checkPromoCode");
    }

    public String getApiCheckValidate() {
        return getConfig("smarttravel.api.leads.checkValidate");
    }

    /**
     * Get web content by Friendly URL
     * @param friendlyUrl
     * @param themeDisplay
     * @return
     */
    public String getWebContentByFriendlyUrl(String friendlyUrl, ThemeDisplay themeDisplay) {
        long groupId = themeDisplay.getScopeGroupId();
        String webContent = "";
        try {
            JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, friendlyUrl);
            JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
                    journalArticle.getArticleId(), "", null, themeDisplay.getLocale().toString(), themeDisplay);
            webContent = articleDisplay.getContent();
        } catch (PortalException e) {
            _log.info(e.getMessage());
        }

        return webContent;
    }

    public String getConfig(String key) {
        String result = StringPool.BLANK;

        try {
            String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
            String filePath = liferayHome + "/agency-portal.json";

            // axa
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

            boolean isValid = isValidJson(jsonData);

            if (!isValid) {
                jsonData = fixMissingCommas(jsonData);
            }

            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonData);

            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
        } catch (Exception e) {
            _log.info(e.getMessage());
        }

        return result;
    }

    private boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static final Pattern KEY_VALUE_PATTERN = Pattern.compile("(\"[^\"]+\"\\s*:\\s*\"[^\"]+\")(\\s+)(\"[^\"]+\"\\s*:\\s*\"[^\"]+\")");

    private String fixMissingCommas(String json) {
        while (json.matches("(?s).*" + KEY_VALUE_PATTERN + ".*")) {
            json = json.replaceAll(KEY_VALUE_PATTERN.toString(), "$1, $3");
        }
        return json;
    }

    public static String capitalizeEachWord(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedString.append(capitalizedWord).append(" ");
            }
        }

        return capitalizedString.toString().trim();
    }

    private static final Log _log = LogFactoryUtil.getLog(MypageHelpers.class);
}
