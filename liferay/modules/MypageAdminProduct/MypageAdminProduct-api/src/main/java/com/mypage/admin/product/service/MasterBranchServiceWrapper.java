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
 * Provides a wrapper for {@link MasterBranchService}.
 *
 * @author Gositus Team
 * @see MasterBranchService
 * @generated
 */
public class MasterBranchServiceWrapper
	implements MasterBranchService, ServiceWrapper<MasterBranchService> {

	public MasterBranchServiceWrapper(MasterBranchService masterBranchService) {
		_masterBranchService = masterBranchService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterBranchService.getOSGiServiceIdentifier();
	}

	@Override
	public MasterBranchService getWrappedService() {
		return _masterBranchService;
	}

	@Override
	public void setWrappedService(MasterBranchService masterBranchService) {
		_masterBranchService = masterBranchService;
	}

	private MasterBranchService _masterBranchService;

}