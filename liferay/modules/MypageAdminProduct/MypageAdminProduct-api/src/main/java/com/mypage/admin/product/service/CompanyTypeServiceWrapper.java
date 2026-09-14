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
 * Provides a wrapper for {@link CompanyTypeService}.
 *
 * @author Gositus Team
 * @see CompanyTypeService
 * @generated
 */
public class CompanyTypeServiceWrapper
	implements CompanyTypeService, ServiceWrapper<CompanyTypeService> {

	public CompanyTypeServiceWrapper(CompanyTypeService companyTypeService) {
		_companyTypeService = companyTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public CompanyTypeService getWrappedService() {
		return _companyTypeService;
	}

	@Override
	public void setWrappedService(CompanyTypeService companyTypeService) {
		_companyTypeService = companyTypeService;
	}

	private CompanyTypeService _companyTypeService;

}