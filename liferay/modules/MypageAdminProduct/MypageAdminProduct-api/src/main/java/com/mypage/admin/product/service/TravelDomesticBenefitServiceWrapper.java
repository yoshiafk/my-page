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
 * Provides a wrapper for {@link TravelDomesticBenefitService}.
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitService
 * @generated
 */
public class TravelDomesticBenefitServiceWrapper
	implements ServiceWrapper<TravelDomesticBenefitService>,
			   TravelDomesticBenefitService {

	public TravelDomesticBenefitServiceWrapper(
		TravelDomesticBenefitService travelDomesticBenefitService) {

		_travelDomesticBenefitService = travelDomesticBenefitService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticBenefitService.getOSGiServiceIdentifier();
	}

	@Override
	public TravelDomesticBenefitService getWrappedService() {
		return _travelDomesticBenefitService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticBenefitService travelDomesticBenefitService) {

		_travelDomesticBenefitService = travelDomesticBenefitService;
	}

	private TravelDomesticBenefitService _travelDomesticBenefitService;

}