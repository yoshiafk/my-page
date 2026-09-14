package com.mypage.product.it2.base;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Collection;

public interface JsonFactoryServiceBase {
	JSONObject createJSONObject();
	JSONObject createJSONObject(String json) throws JSONException;
	
	JSONArray createJSONArray();
	JSONArray createJSONArray(Collection<?> collection);
	JSONArray createJSONArray(String json) throws JSONException;
}
