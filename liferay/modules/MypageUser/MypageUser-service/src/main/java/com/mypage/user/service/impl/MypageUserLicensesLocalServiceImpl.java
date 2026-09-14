/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mypage.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.mypage.user.model.MypageUserLicenses;
import com.mypage.user.service.base.MypageUserLicensesLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageUserLicenses",
	service = AopService.class
)
public class MypageUserLicensesLocalServiceImpl
	extends MypageUserLicensesLocalServiceBaseImpl {
	
	/*
	 * Add MypageUserLicenses 
	 */
	public MypageUserLicenses addMypageUserLicense(long mypageUserId, long productId) {
		MypageUserLicenses license = null;
		
		long licenseId = counterLocalService.increment();
		license = mypageUserLicensesPersistence.create(licenseId);
		license.setMypageUserId(mypageUserId);
		license.setProductId(productId);
		mypageUserLicensesPersistence.update(license);
		
		return license;
	}
	
	/* 
	 * Delete user licenses
	 */
	public void removeByMypageUserId(long mypageUserId) {
		mypageUserLicensesPersistence.removeBygetByMypageUserId(mypageUserId);
	}
	
	/* 
	 * Get MypageUserLicence by their ids 
	 */
	public List<MypageUserLicenses> getByMypageUserId(long mypageUserId) {
		return mypageUserLicensesPersistence.findBygetByMypageUserId(mypageUserId);
	}	
}