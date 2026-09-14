package com.mypage.product.pet.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsUtil;

import java.io.FileReader;

public class MypageHelpers {
	/**
	 * Get web content by Friendly URL
	 * @param friendlyUrl
	 * @param themeDisplay
	 * @return
	 */
	public static String getWebContentByFriendlyUrl(String friendlyUrl, ThemeDisplay themeDisplay) {
		long groupId = themeDisplay.getScopeGroupId();
		String webContent = "";
		try {
			JournalArticle _webContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, friendlyUrl);
			JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
					_webContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
			webContent = articleDisplay.getContent();
		} catch (PortalException e) {
			System.out.println(e.getMessage());
		}

		return webContent;
	}
	
	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME); // System.getProperty("catalina.base");
            String filePath = liferayHome + "/agency-portal.json";
			
			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
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

}
