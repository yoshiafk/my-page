package com.mypage.product.it2.wrapper;

import com.liferay.portal.util.PropsUtil;
import com.mypage.product.it2.base.PropsUtilServiceBase;

public class PropsUtilService implements PropsUtilServiceBase {

	@Override
	public String get(String key) {
		return PropsUtil.get(key);
	}

}