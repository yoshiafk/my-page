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

package com.mypage.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserRegistrationJobExpService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationJobExpService
 * @generated
 */
public class UserRegistrationJobExpServiceWrapper
	implements ServiceWrapper<UserRegistrationJobExpService>,
			   UserRegistrationJobExpService {

	public UserRegistrationJobExpServiceWrapper(
		UserRegistrationJobExpService userRegistrationJobExpService) {

		_userRegistrationJobExpService = userRegistrationJobExpService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationJobExpService.getOSGiServiceIdentifier();
	}

	@Override
	public UserRegistrationJobExpService getWrappedService() {
		return _userRegistrationJobExpService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationJobExpService userRegistrationJobExpService) {

		_userRegistrationJobExpService = userRegistrationJobExpService;
	}

	private UserRegistrationJobExpService _userRegistrationJobExpService;

}