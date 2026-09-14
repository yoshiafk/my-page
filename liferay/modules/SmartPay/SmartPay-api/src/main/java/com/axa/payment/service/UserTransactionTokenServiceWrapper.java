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

package com.axa.payment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserTransactionTokenService}.
 *
 * @author Gositus Team
 * @see UserTransactionTokenService
 * @generated
 */
public class UserTransactionTokenServiceWrapper
	implements ServiceWrapper<UserTransactionTokenService>,
			   UserTransactionTokenService {

	public UserTransactionTokenServiceWrapper(
		UserTransactionTokenService userTransactionTokenService) {

		_userTransactionTokenService = userTransactionTokenService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userTransactionTokenService.getOSGiServiceIdentifier();
	}

	@Override
	public UserTransactionTokenService getWrappedService() {
		return _userTransactionTokenService;
	}

	@Override
	public void setWrappedService(
		UserTransactionTokenService userTransactionTokenService) {

		_userTransactionTokenService = userTransactionTokenService;
	}

	private UserTransactionTokenService _userTransactionTokenService;

}