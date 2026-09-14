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
import com.mypage.admin.product.exception.NoSuchMasterOccupationException;
import com.mypage.admin.product.model.MasterOccupation;
import com.mypage.admin.product.service.base.MasterOccupationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterOccupation",
	service = AopService.class
)
public class MasterOccupationLocalServiceImpl
	extends MasterOccupationLocalServiceBaseImpl {
	public MasterOccupation addMasterOccupation(String name, long masterOccupationCategoryId, int active) {
		long masterOccupationId = counterLocalService.increment();
		MasterOccupation masterOccupation = masterOccupationPersistence.create(masterOccupationId);

		masterOccupation.setName(name);
		masterOccupation.setMasterOccupationCategoryId(masterOccupationCategoryId);
		masterOccupation.setActive(active);

		return masterOccupationPersistence.update(masterOccupation);
	}

	public MasterOccupation updateMasterOccupation(long masterOccupationId, String name,
			long masterOccupationCategoryId, int active) throws NoSuchMasterOccupationException {
		MasterOccupation masterOccupation = masterOccupationPersistence.findByPrimaryKey(masterOccupationId);

		masterOccupation.setName(name);
		masterOccupation.setMasterOccupationCategoryId(masterOccupationCategoryId);
		masterOccupation.setActive(active);

		return masterOccupationPersistence.update(masterOccupation);
	}

	public MasterOccupation setActive(long masterOccupationId, int active) {
		MasterOccupation masterOccupation = null;
		try {
			masterOccupation = masterOccupationPersistence.findByPrimaryKey(masterOccupationId);
			masterOccupation.setActive(active);
			masterOccupationPersistence.update(masterOccupation);
		} catch (NoSuchMasterOccupationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return masterOccupation;
	}

	public List<MasterOccupation> searchByActive(int active) {
		return masterOccupationPersistence.findBysearchByActive(active);
	}

	public List<MasterOccupation> searchByMasterOccupationCategoryId(long masterOccupationCategoryId) {
		return masterOccupationPersistence.findBysearchByMasterOccupationCategoryId(masterOccupationCategoryId);
	}	
}