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
 * Provides a wrapper for {@link TravelDomesticPlanService}.
 *
 * @author Gositus Team
 * @see TravelDomesticPlanService
 * @generated
 */
public class TravelDomesticPlanServiceWrapper
	implements ServiceWrapper<TravelDomesticPlanService>,
			   TravelDomesticPlanService {

	public TravelDomesticPlanServiceWrapper(
		TravelDomesticPlanService travelDomesticPlanService) {

		_travelDomesticPlanService = travelDomesticPlanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticPlanService.getOSGiServiceIdentifier();
	}

	@Override
	public TravelDomesticPlanService getWrappedService() {
		return _travelDomesticPlanService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticPlanService travelDomesticPlanService) {

		_travelDomesticPlanService = travelDomesticPlanService;
	}

	private TravelDomesticPlanService _travelDomesticPlanService;

}