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
import com.mypage.admin.product.model.SmartHealthBenefitGroup;
import com.mypage.admin.product.service.base.SmartHealthBenefitGroupLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartHealthBenefitGroup",
	service = AopService.class
)
public class SmartHealthBenefitGroupLocalServiceImpl
	extends SmartHealthBenefitGroupLocalServiceBaseImpl {
	
	/**
	 * Add Benefit Group
	 */
	public SmartHealthBenefitGroup addSmartHealthBenefitGroup(String groupName, String groupDescription,
			String groupCode, int active) throws PortalException {
		long smartHealthBenefitGroupId = counterLocalService.increment();
		SmartHealthBenefitGroup smartHealthBenefitGroup = smartHealthBenefitGroupPersistence
				.create(smartHealthBenefitGroupId);

		smartHealthBenefitGroup.setGroupName(groupName);
		smartHealthBenefitGroup.setGroupDescription(groupDescription);
		smartHealthBenefitGroup.setGroupCode(groupCode);
		smartHealthBenefitGroup.setActive(active);

		smartHealthBenefitGroupPersistence.update(smartHealthBenefitGroup);

		return smartHealthBenefitGroup;
	}
	
	/**
	 * Update Benefit Group
	 */
	public SmartHealthBenefitGroup updateSmartHealthBenefitGroup(long smartHealthBenefitGroupId, String groupName,
			String groupDescription, String groupCode, int active) throws PortalException {
		SmartHealthBenefitGroup smartHealthBenefitGroup = smartHealthBenefitGroupPersistence
				.findByPrimaryKey(smartHealthBenefitGroupId);

		smartHealthBenefitGroup.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
		smartHealthBenefitGroup.setGroupName(groupName);
		smartHealthBenefitGroup.setGroupDescription(groupDescription);
		smartHealthBenefitGroup.setGroupCode(groupCode);
		smartHealthBenefitGroup.setActive(active);

		smartHealthBenefitGroupPersistence.update(smartHealthBenefitGroup);

		return smartHealthBenefitGroup;
	}
	
	public List<SmartHealthBenefitGroup> getSmartHealthBenefitGroups() {
		return smartHealthBenefitGroupPersistence.findAll();
	}

	public int getSmartHealthBenefitGroupCounts() {
		return smartHealthBenefitGroupPersistence.countAll();
	}
	
	public SmartHealthBenefitGroup setActive(long smartHealthBenefitGroupId, int active, ServiceContext serviceContext)
			throws PortalException {
		SmartHealthBenefitGroup smartHealthBenefitGroup = null;

		try {
			smartHealthBenefitGroup = smartHealthBenefitGroupPersistence.findByPrimaryKey(smartHealthBenefitGroupId);
			Date now = new Date();
			smartHealthBenefitGroup.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
			smartHealthBenefitGroup.setActive(active);
			smartHealthBenefitGroup.setModifiedDate(serviceContext.getModifiedDate(now));

			smartHealthBenefitGroupPersistence.update(smartHealthBenefitGroup);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return smartHealthBenefitGroup;
	}

    private static final Log log = LogFactoryUtil.getLog(SmartHealthBenefitGroupLocalServiceImpl.class);
}