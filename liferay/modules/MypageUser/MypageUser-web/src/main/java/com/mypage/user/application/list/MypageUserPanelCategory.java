package com.mypage.user.application.list;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.user.constants.MypageUserPanelCategoryKeys;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
"panel.category.order:Integer=50" }, service = PanelCategory.class)

public class MypageUserPanelCategory extends BasePanelCategory {
	@Override
	public String getKey() {
		return MypageUserPanelCategoryKeys.MYPAGE_USER_CATEGORY;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "admin_sidebar_user_category");
	}
	
	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group) throws PortalException {
        long siteId = permissionChecker.getUser().getCompanyId();
        
        // JIKA GAGAL GET CONFIG, KEMUNGKINAN ADA TANDA BACA YANG KURANG PADA AGENCY JSON
    	long instance = Validator.isNull(getConfig("com.mypage.agent.config.instance")) ? 0 : Long.valueOf(getConfig("com.mypage.agent.config.instance"));
		
		if (siteId == instance) return true;
		
		return false;
	}
	
	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME); // System.getProperty("catalina.base");
            String filePath = liferayHome + "/agency-portal.json";
			
         // sonia
//			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
//            JsonObject jsonObject = jsonElement.getAsJsonObject();
            
            // axa
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            
            boolean isValid = isValidJson(jsonData);
            
            if (isValid == false) {
            	jsonData = fixMissingCommas(jsonData);
            }
            
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonData);
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
			e.printStackTrace();
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
	
	private static final Pattern KEY_VALUE_PATTERN = Pattern.compile("^\"[^\"]+\"\\s*:");
	
	private String fixMissingCommas(String json) {
		String[] lines = json.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String current = lines[i].trim();
            result.append(lines[i]);
            if (i < lines.length - 2 && KEY_VALUE_PATTERN.matcher(current).find() && !current.endsWith(",")) {
                String next = lines[i + 1].trim();
                if (KEY_VALUE_PATTERN.matcher(next).find()) {
                    result.append(",");
                }
            }
            result.append("\n");
        }
        return result.toString();
	}
}
