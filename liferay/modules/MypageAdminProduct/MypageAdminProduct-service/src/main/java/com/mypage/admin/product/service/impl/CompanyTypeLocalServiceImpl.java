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

package com.mypage.admin.product.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.CompanyType;
import com.mypage.admin.product.service.base.CompanyTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.CompanyType",
	service = AopService.class
)
public class CompanyTypeLocalServiceImpl
	extends CompanyTypeLocalServiceBaseImpl {
	public CompanyType addCompanyType(String name, String label, int sort, int active) throws PortalException {
		long companyTypeId = counterLocalService.increment();
		CompanyType companyType = companyTypePersistence.create(companyTypeId);

		companyType.setName(name);
		companyType.setLabel(label);
		companyType.setSort(sort);
		companyType.setActive(active);

		companyTypePersistence.update(companyType);

		return companyType;
	}

	public CompanyType updateCompanyType(long companyTypeId, String name, String label, int sort, int active)
			throws PortalException {
		CompanyType companyType = companyTypePersistence.findByPrimaryKey(companyTypeId);

		companyType.setCompanyTypeId(companyTypeId);
		companyType.setName(name);
		companyType.setLabel(label);
		companyType.setSort(sort);
		companyType.setActive(active);

		companyTypePersistence.update(companyType);

		return companyType;
	}

	public List<CompanyType> getCompanyTypes(int start, int end) {
		return companyTypePersistence.findAll(start, end);
	}

	public List<CompanyType> getCompanyTypes() {
		return companyTypePersistence.findAll();
	}

	public int getCompanyTypeCount() {
		return companyTypePersistence.countAll();
	}

	public CompanyType setActive(long userId, long companyTypeId, int active, ServiceContext serviceContext)
			throws PortalException {
		CompanyType companyType = null;

		try {
			companyType = companyTypePersistence.findByPrimaryKey(companyTypeId);
			Date now = new Date();
			companyType.setCompanyTypeId(companyTypeId);
			companyType.setActive(active);
			companyType.setModifiedDate(serviceContext.getModifiedDate(now));

			companyTypePersistence.update(companyType);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return companyType;
	}

    private static final Log log = LogFactoryUtil.getLog(CompanyTypeLocalServiceImpl.class);
}