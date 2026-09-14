package com.mypage.product.it2.wrapper;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.mypage.product.it2.base.JsonFactoryServiceBase;

import java.util.Collection;

public class JsonFactoryService implements JsonFactoryServiceBase {

	@Override
	public JSONObject createJSONObject() {
		return JSONFactoryUtil.createJSONObject();
	}

	@Override
	public JSONObject createJSONObject(String json) throws JSONException {
		return JSONFactoryUtil.createJSONObject(json);
	}

	@Override
	public JSONArray createJSONArray() {
		return JSONFactoryUtil.createJSONArray();
	}

	@Override
	public JSONArray createJSONArray(Collection<?> collection) {
		return JSONFactoryUtil.createJSONArray(collection);
	}

	@Override
	public JSONArray createJSONArray(String json) throws JSONException {
		return JSONFactoryUtil.createJSONArray(json);
	}
}
