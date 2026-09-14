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
 * Provides a wrapper for {@link SmartActiveBenefitValueMappingService}.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueMappingService
 * @generated
 */
public class SmartActiveBenefitValueMappingServiceWrapper
	implements ServiceWrapper<SmartActiveBenefitValueMappingService>,
			   SmartActiveBenefitValueMappingService {

	public SmartActiveBenefitValueMappingServiceWrapper(
		SmartActiveBenefitValueMappingService
			smartActiveBenefitValueMappingService) {

		_smartActiveBenefitValueMappingService =
			smartActiveBenefitValueMappingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveBenefitValueMappingService.
			getOSGiServiceIdentifier();
	}

	@Override
	public SmartActiveBenefitValueMappingService getWrappedService() {
		return _smartActiveBenefitValueMappingService;
	}

	@Override
	public void setWrappedService(
		SmartActiveBenefitValueMappingService
			smartActiveBenefitValueMappingService) {

		_smartActiveBenefitValueMappingService =
			smartActiveBenefitValueMappingService;
	}

	private SmartActiveBenefitValueMappingService
		_smartActiveBenefitValueMappingService;

}