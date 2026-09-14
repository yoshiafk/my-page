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
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.Industry;
import com.mypage.admin.product.service.base.IndustryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.Industry",
	service = AopService.class
)
public class IndustryLocalServiceImpl extends IndustryLocalServiceBaseImpl {
	public Industry addIndustry(String name, long industryCategoryId, int active) throws PortalException {
		long industryId = counterLocalService.increment();
		Industry industry = industryPersistence.create(industryId);

		industry.setName(name);
		industry.setIndustryCategoryId(industryCategoryId);
		industry.setActive(active);

		industryPersistence.update(industry);

		return industry;
	}

	public Industry updateIndustry(long industryId, long industryCategoryId, String name, int active)
			throws PortalException {
		Industry industry = industryPersistence.findByPrimaryKey(industryId);

		industry.setIndustryId(industryId);
		industry.setName(name);
		industry.setIndustryCategoryId(industryCategoryId);
		industry.setActive(active);

		industryPersistence.update(industry);

		return industry;
	}

	public List<Industry> getIndustries() {
		return industryPersistence.findAll();
	}

	public int getIndustryCount() {
		return industryPersistence.countAll();
	}

	public Industry setActive(long industryId, int active, ServiceContext serviceContext) throws PortalException {
		Industry industry = null;

		try {
			industry = industryPersistence.findByPrimaryKey(industryId);
			Date now = new Date();
			industry.setIndustryId(industryId);
			industry.setActive(active);
			industry.setModifiedDate(serviceContext.getModifiedDate(now));

			industryPersistence.update(industry);
		} catch (Exception e) {
			System.out.println(e);
		}

		return industry;
	}	
}