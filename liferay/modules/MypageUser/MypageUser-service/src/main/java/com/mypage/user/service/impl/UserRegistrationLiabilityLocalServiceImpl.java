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
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.user.model.UserRegistrationLiability;
import com.mypage.user.service.base.UserRegistrationLiabilityLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserRegistrationLiability",
	service = AopService.class
)
public class UserRegistrationLiabilityLocalServiceImpl
	extends UserRegistrationLiabilityLocalServiceBaseImpl {
	
	public UserRegistrationLiability addUserRegistrationLiability(String name, String relationship, int age,
			long userRegistrationId, ServiceContext serviceContext) throws PortalException {
		long userRegistrationLiabilityId = counterLocalService.increment();
		UserRegistrationLiability userRegistrationLiability = userRegistrationLiabilityPersistence
				.create(userRegistrationLiabilityId);

		userRegistrationLiability.setName(name);
		userRegistrationLiability.setRelationship(relationship);
		userRegistrationLiability.setAge(age);
		userRegistrationLiability.setUserRegistrationId(userRegistrationId);

		userRegistrationLiabilityPersistence.update(userRegistrationLiability);

		return userRegistrationLiability;
	}	
}