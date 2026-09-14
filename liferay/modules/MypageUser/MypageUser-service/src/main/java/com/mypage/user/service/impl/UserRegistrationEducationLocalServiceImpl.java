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
import com.liferay.portal.kernel.exception.PortalException;
import com.mypage.user.model.UserRegistrationEducation;
import com.mypage.user.service.base.UserRegistrationEducationLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserRegistrationEducation",
	service = AopService.class
)
public class UserRegistrationEducationLocalServiceImpl
	extends UserRegistrationEducationLocalServiceBaseImpl {
	
	public UserRegistrationEducation addUserRegistrationEducation(String name, int year, int graduate, String title,
			String courseType, String eduType, long userRegistrationId) throws PortalException {
		long userRegistrationEducationId = counterLocalService.increment();
		UserRegistrationEducation userRegistrationEducation = userRegistrationEducationPersistence
				.create(userRegistrationEducationId);

		userRegistrationEducation.setName(name);
		userRegistrationEducation.setYear(year);
		userRegistrationEducation.setGraduate(graduate);
		userRegistrationEducation.setTitle(title);
		userRegistrationEducation.setCourseType(courseType);
		userRegistrationEducation.setEduType(eduType);
		userRegistrationEducation.setUserRegistrationId(userRegistrationId);

		userRegistrationEducationPersistence.update(userRegistrationEducation);

		return userRegistrationEducation;

	}	
}