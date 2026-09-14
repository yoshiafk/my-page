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
import com.mypage.user.model.MypageUserWorkingHour;
import com.mypage.user.service.base.MypageUserWorkingHourLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageUserWorkingHour",
	service = AopService.class
)
public class MypageUserWorkingHourLocalServiceImpl
	extends MypageUserWorkingHourLocalServiceBaseImpl {
	/*
	 * add working hour 
	 */
	public MypageUserWorkingHour addWorkingHour(long mypageUserId, String day, String startTime, String endTime, int status) {
		MypageUserWorkingHour workingHour = null;
		
		long mypageUserWorkingHourId = counterLocalService.increment();
		workingHour = mypageUserWorkingHourPersistence.create(mypageUserWorkingHourId);
		workingHour.setMypageUserId(mypageUserId);
		workingHour.setDay(day);
		workingHour.setStartTime(startTime);
		workingHour.setEndTime(endTime);
		workingHour.setStatus(status);
		mypageUserWorkingHourPersistence.update(workingHour);
		return workingHour;
	}
	
	/*
	 * delete working hour by mypageuserid
	 */
	public void removeByMypageUserId(long mypageUserId) {
		mypageUserWorkingHourPersistence.removeBygetByMypageUserId(mypageUserId);
	}
	
	/*
	 * get working hour by mypageuserid
	 */
	public List<MypageUserWorkingHour> getByMypageUserId(long mypageUserId) {
		return mypageUserWorkingHourPersistence.findBygetByMypageUserId(mypageUserId);
	}	
}