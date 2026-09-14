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

package com.mypage.leads.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DetailPetService}.
 *
 * @author Gositus
 * @see DetailPetService
 * @generated
 */
public class DetailPetServiceWrapper
	implements DetailPetService, ServiceWrapper<DetailPetService> {

	public DetailPetServiceWrapper(DetailPetService detailPetService) {
		_detailPetService = detailPetService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailPetService.getOSGiServiceIdentifier();
	}

	@Override
	public DetailPetService getWrappedService() {
		return _detailPetService;
	}

	@Override
	public void setWrappedService(DetailPetService detailPetService) {
		_detailPetService = detailPetService;
	}

	private DetailPetService _detailPetService;

}