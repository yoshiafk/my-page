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
import com.mypage.user.model.UserOneTimeCode;
import com.mypage.user.service.base.UserOneTimeCodeLocalServiceBaseImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserOneTimeCode",
	service = AopService.class
)
public class UserOneTimeCodeLocalServiceImpl extends UserOneTimeCodeLocalServiceBaseImpl {
	
	public UserOneTimeCode addUserOTP(long userId, String sharedSecret, int expiresIn) {
		
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		long userOneTimeCodeId = counterLocalService.increment();
		
		UserOneTimeCode userOneTimeCode = userOneTimeCodePersistence.create(userOneTimeCodeId);

		userOneTimeCode.setUserId(userId);
		userOneTimeCode.setSharedSecret(sharedSecret);
		userOneTimeCode.setCreateDate(now);
		userOneTimeCode.setModifiedDate(now);
		
		zonedDateTime = localDateTime.atZone(ZoneId.systemDefault()).plusMinutes(expiresIn);
		instantDate = zonedDateTime.toInstant();
		now = Date.from(instantDate);
		
		userOneTimeCode.setExpiryDate(now);
		userOneTimeCode.setTimestampExpiryDate((System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(expiresIn)) / 1000);
		userOneTimeCode.setIsUsed(0);

		userOneTimeCodePersistence.update(userOneTimeCode);

		return userOneTimeCode;
	}
	
public UserOneTimeCode updateUserOTP(long userId, String sharedSecret) {
		
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		UserOneTimeCode userOneTimeCode = userOneTimeCodePersistence.fetchByUserIdSecret(userId, sharedSecret);
		
		userOneTimeCode.setModifiedDate(now);
		userOneTimeCode.setIsUsed(1);

		userOneTimeCodePersistence.update(userOneTimeCode);

		return userOneTimeCode;
	}

	public List<UserOneTimeCode> getUserOTPUnused(long userId) {
		List<UserOneTimeCode> userOneTimeCode = userOneTimeCodePersistence.findByUserIdCollection(userId).stream().filter(v -> v.getIsUsed() == 0).collect(Collectors.toList());
		
		return userOneTimeCode;
	}
	
	public UserOneTimeCode getUserOTP(long userId, String sharedSecret) {
		UserOneTimeCode userOneTimeCode = userOneTimeCodePersistence.fetchByUserIdSecret(userId, sharedSecret);
		
		return userOneTimeCode;
	}
}