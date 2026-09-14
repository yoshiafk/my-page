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

package com.mypage.agencyportal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AgentFAQCategoryService}.
 *
 * @author Gositus Team
 * @see AgentFAQCategoryService
 * @generated
 */
public class AgentFAQCategoryServiceWrapper
	implements AgentFAQCategoryService,
			   ServiceWrapper<AgentFAQCategoryService> {

	public AgentFAQCategoryServiceWrapper(
		AgentFAQCategoryService agentFAQCategoryService) {

		_agentFAQCategoryService = agentFAQCategoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agentFAQCategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public AgentFAQCategoryService getWrappedService() {
		return _agentFAQCategoryService;
	}

	@Override
	public void setWrappedService(
		AgentFAQCategoryService agentFAQCategoryService) {

		_agentFAQCategoryService = agentFAQCategoryService;
	}

	private AgentFAQCategoryService _agentFAQCategoryService;

}