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
import com.mypage.user.model.UserRegistrationReference;
import com.mypage.user.service.base.UserRegistrationReferenceLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserRegistrationReference",
	service = AopService.class
)
public class UserRegistrationReferenceLocalServiceImpl
	extends UserRegistrationReferenceLocalServiceBaseImpl {
	
	public UserRegistrationReference addUserRegistrationReference(String name, String relation, int age, String address,
			String phone, String job, int year, long userRegistrationId) throws PortalException {
		long userRegistrationReferenceId = counterLocalService.increment();
		UserRegistrationReference userRegistrationReference = userRegistrationReferencePersistence
				.create(userRegistrationReferenceId);

		userRegistrationReference.setName(name);
		userRegistrationReference.setRelation(relation);
		userRegistrationReference.setAge(age);
		userRegistrationReference.setAddress(address);
		userRegistrationReference.setPhone(phone);
		userRegistrationReference.setJob(job);
		userRegistrationReference.setYear(year);
		userRegistrationReference.setUserRegistrationId(userRegistrationId);

		userRegistrationReferencePersistence.update(userRegistrationReference);

		return userRegistrationReference;

	}	
}