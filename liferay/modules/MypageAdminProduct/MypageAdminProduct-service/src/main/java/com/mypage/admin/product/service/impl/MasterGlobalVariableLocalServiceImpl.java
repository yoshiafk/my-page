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
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.base.MasterGlobalVariableLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterGlobalVariable",
	service = AopService.class
)
public class MasterGlobalVariableLocalServiceImpl
	extends MasterGlobalVariableLocalServiceBaseImpl {
	
	public MasterGlobalVariable addMasterGlobalVariable(String group, String name, String value, String imageURL,
			long imageFileEntryId, int active) throws PortalException {
		long globalVariableId = counterLocalService.increment();
		MasterGlobalVariable masterGlobalVariable = masterGlobalVariablePersistence.create(globalVariableId);
		
		masterGlobalVariable.setGroup(group);
		masterGlobalVariable.setName(name);
		masterGlobalVariable.setValue(Validator.isNull(imageURL) ? value : imageURL);
		masterGlobalVariable.setImageFileEntryId(imageFileEntryId);
		masterGlobalVariable.setActive(active);

		masterGlobalVariablePersistence.update(masterGlobalVariable);

		return masterGlobalVariable;
	}
	
	public MasterGlobalVariable updateMasterGlobalVariable(long masterGlobalVariableId, String group, String name, String value,
			String imageURL, long imageFileEntryId, int active) throws PortalException {
		MasterGlobalVariable masterGlobalVariable = masterGlobalVariablePersistence.findByPrimaryKey(masterGlobalVariableId);
		
		masterGlobalVariable.setGroup(group);
		masterGlobalVariable.setName(name);
		masterGlobalVariable.setValue(Validator.isNull(imageURL) ? value : imageURL);
		
		if (imageFileEntryId > 0) masterGlobalVariable.setImageFileEntryId(imageFileEntryId);
		
		masterGlobalVariable.setActive(active);

		masterGlobalVariablePersistence.update(masterGlobalVariable);

		return masterGlobalVariable;
	}

	public MasterGlobalVariable setActive(long masterGlobalVariableId, int active, ServiceContext serviceContext) throws PortalException {
		MasterGlobalVariable masterGlobalVariable = null;

		try {
			masterGlobalVariable = masterGlobalVariablePersistence.findByPrimaryKey(masterGlobalVariableId);
			Date now = new Date();
			masterGlobalVariable.setActive(active);
			masterGlobalVariable.setModifiedDate(serviceContext.getModifiedDate(now));

			masterGlobalVariablePersistence.update(masterGlobalVariable);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterGlobalVariable;
	}
	
	public List<MasterGlobalVariable> getActiveGlobalVariableByGroup(String groupName) {
		return (List<MasterGlobalVariable>) masterGlobalVariablePersistence.findAll().stream()
				.filter(v -> v.getActive() == 1 && v.getGroup().equalsIgnoreCase(groupName))
				.collect(Collectors.toList());
	}
}