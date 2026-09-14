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
 * Provides a wrapper for {@link HealthSmeTypeService}.
 *
 * @author Gositus Team
 * @see HealthSmeTypeService
 * @generated
 */
public class HealthSmeTypeServiceWrapper
	implements HealthSmeTypeService, ServiceWrapper<HealthSmeTypeService> {

	public HealthSmeTypeServiceWrapper(
		HealthSmeTypeService healthSmeTypeService) {

		_healthSmeTypeService = healthSmeTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _healthSmeTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public HealthSmeTypeService getWrappedService() {
		return _healthSmeTypeService;
	}

	@Override
	public void setWrappedService(HealthSmeTypeService healthSmeTypeService) {
		_healthSmeTypeService = healthSmeTypeService;
	}

	private HealthSmeTypeService _healthSmeTypeService;

}