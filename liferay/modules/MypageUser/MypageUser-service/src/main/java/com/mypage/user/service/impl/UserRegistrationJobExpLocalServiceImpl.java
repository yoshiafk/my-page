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
import com.mypage.user.model.UserRegistrationJobExp;
import com.mypage.user.service.base.UserRegistrationJobExpLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.UserRegistrationJobExp",
	service = AopService.class
)
public class UserRegistrationJobExpLocalServiceImpl
	extends UserRegistrationJobExpLocalServiceBaseImpl {
	
	public UserRegistrationJobExp addUserRegistrationJobExp(String name, int year, String jobHead, String jobPosition,
			String jobIncome, int otherInsuranceCompany, long userRegistrationId) throws PortalException {
		long userRegistrationJobExpId = counterLocalService.increment();
		UserRegistrationJobExp userRegistrationJobExp = userRegistrationJobExpPersistence
				.create(userRegistrationJobExpId);

		userRegistrationJobExp.setName(name);
		userRegistrationJobExp.setYear(year);
		userRegistrationJobExp.setJobHead(jobHead);
		userRegistrationJobExp.setJobPosition(jobPosition);
		userRegistrationJobExp.setJobIncome(jobIncome);
		userRegistrationJobExp.setOtherInsuranceCompany(otherInsuranceCompany);
		userRegistrationJobExp.setUserRegistrationId(userRegistrationId);

		userRegistrationJobExpPersistence.update(userRegistrationJobExp);

		return userRegistrationJobExp;
	}	
}