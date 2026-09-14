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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterBankService}.
 *
 * @author Gositus Team
 * @see MasterBankService
 * @generated
 */
public class MasterBankServiceWrapper
	implements MasterBankService, ServiceWrapper<MasterBankService> {

	public MasterBankServiceWrapper(MasterBankService masterBankService) {
		_masterBankService = masterBankService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterBankService.getOSGiServiceIdentifier();
	}

	@Override
	public MasterBankService getWrappedService() {
		return _masterBankService;
	}

	@Override
	public void setWrappedService(MasterBankService masterBankService) {
		_masterBankService = masterBankService;
	}

	private MasterBankService _masterBankService;

}