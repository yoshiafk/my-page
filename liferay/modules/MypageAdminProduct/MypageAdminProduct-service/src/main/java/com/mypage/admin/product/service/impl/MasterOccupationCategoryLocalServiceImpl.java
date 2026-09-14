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
import com.mypage.admin.product.exception.NoSuchMasterOccupationCategoryException;
import com.mypage.admin.product.model.MasterOccupationCategory;
import com.mypage.admin.product.service.base.MasterOccupationCategoryLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterOccupationCategory",
	service = AopService.class
)
public class MasterOccupationCategoryLocalServiceImpl
	extends MasterOccupationCategoryLocalServiceBaseImpl {
	
	public MasterOccupationCategory addMasterOccupationCategory(String name, int active) {
		long masterOccupationCategoryId = counterLocalService.increment();
		MasterOccupationCategory masterOccupationCategory = masterOccupationCategoryPersistence
				.create(masterOccupationCategoryId);

		masterOccupationCategory.setName(name);
		masterOccupationCategory.setActive(active);

		return masterOccupationCategoryPersistence.update(masterOccupationCategory);
	}

	public MasterOccupationCategory updateMasterOccupationCategory(long masterOccupationCategoryId, String name,
			int active) throws NoSuchMasterOccupationCategoryException {
		MasterOccupationCategory masterOccupationCategory = masterOccupationCategoryPersistence
				.findByPrimaryKey(masterOccupationCategoryId);

		masterOccupationCategory.setName(name);
		masterOccupationCategory.setActive(active);

		return masterOccupationCategoryPersistence.update(masterOccupationCategory);
	}

	public MasterOccupationCategory setActive(long masterOccupationCategoryId, int active) {
		MasterOccupationCategory masterOccupationCategory = null;
		try {
			masterOccupationCategory = masterOccupationCategoryPersistence.findByPrimaryKey(masterOccupationCategoryId);
			masterOccupationCategory.setActive(active);
			masterOccupationCategoryPersistence.update(masterOccupationCategory);
		} catch (NoSuchMasterOccupationCategoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return masterOccupationCategory;
	}

	public List<MasterOccupationCategory> searchByActive(int active) {
		return masterOccupationCategoryPersistence.findBysearchByActive(active);
	}

	public MasterOccupationCategory searchByName(String name) {
		return masterOccupationCategoryPersistence.fetchBysearchName(name);
	}
}