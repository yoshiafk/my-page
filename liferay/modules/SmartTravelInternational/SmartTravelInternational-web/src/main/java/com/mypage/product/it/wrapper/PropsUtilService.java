package com.mypage.product.it.wrapper;

import com.liferay.portal.util.PropsUtil;
import com.mypage.product.it.base.PropsUtilServiceBase;

public class PropsUtilService implements PropsUtilServiceBase {

	@Override
	public String get(String key) {
		return PropsUtil.get(key);
	}

}
