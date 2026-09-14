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
import com.mypage.admin.product.model.JobPosition;
import com.mypage.admin.product.service.base.JobPositionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.JobPosition",
	service = AopService.class
)
public class JobPositionLocalServiceImpl
	extends JobPositionLocalServiceBaseImpl {
	
	public JobPosition addJobPosition(String name, int active) throws PortalException {
		long jobPositionId = counterLocalService.increment();
		JobPosition jobPosition = jobPositionPersistence.create(jobPositionId);

		jobPosition.setName(name);
		jobPosition.setActive(active);

		jobPositionPersistence.update(jobPosition);

		return jobPosition;
	}

	public JobPosition updateJobPosition(long jobPositionId, String name, int active) throws PortalException {
		JobPosition jobPosition = jobPositionPersistence.findByPrimaryKey(jobPositionId);

		jobPosition.setJobPositionId(jobPositionId);
		jobPosition.setName(name);
		jobPosition.setActive(active);

		jobPositionPersistence.update(jobPosition);

		return jobPosition;
	}

	public List<JobPosition> getJobPositions(int start, int end) {
		return jobPositionPersistence.findAll(start, end);
	}

	public List<JobPosition> getJobPositions() {
		return jobPositionPersistence.findAll();
	}

	public int getJobPositionCount() {
		return jobPositionPersistence.countAll();
	}

	public JobPosition setActive(long jobPositionId, int active, ServiceContext serviceContext) throws PortalException {
		JobPosition jobPosition = null;

		try {
			jobPosition = jobPositionPersistence.findByPrimaryKey(jobPositionId);
			Date now = new Date();
			jobPosition.setJobPositionId(jobPositionId);
			jobPosition.setActive(active);
			jobPosition.setModifiedDate(serviceContext.getModifiedDate(now));

			jobPositionPersistence.update(jobPosition);
		} catch (Exception e) {
			System.out.println(e);
		}

		return jobPosition;
	}	
}