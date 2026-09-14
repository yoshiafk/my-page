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
import com.mypage.admin.product.exception.NoSuchMasterBranchException;
import com.mypage.admin.product.model.MasterBranch;
import com.mypage.admin.product.service.base.MasterBranchLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterBranch",
	service = AopService.class
)
public class MasterBranchLocalServiceImpl
	extends MasterBranchLocalServiceBaseImpl {
	
	public MasterBranch addMasterBranch(String name, String agiCode, String magiCode, int active) {
		long masterBranchId = counterLocalService.increment();

		MasterBranch masterBranch = masterBranchPersistence.create(masterBranchId);
		masterBranch.setName(name);
		masterBranch.setAgiCode(magiCode);
		masterBranch.setMagiCode(magiCode);
		masterBranch.setActive(active);

		return masterBranchPersistence.update(masterBranch);
	}

	public MasterBranch updateMasterBranch(long masterBranchId, String name, String agiCode, String magiCode,
			int active) {
		MasterBranch masterBranch = null;

		try {
			masterBranch = masterBranchPersistence.findByPrimaryKey(masterBranchId);
			masterBranch.setName(name);
			masterBranch.setAgiCode(magiCode);
			masterBranch.setMagiCode(magiCode);
			masterBranch.setActive(active);
		} catch (NoSuchMasterBranchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return masterBranchPersistence.update(masterBranch);
	}

	public MasterBranch setActive(long masterBranchId, int active) {
		MasterBranch masterBranch = null;

		try {
			masterBranch = masterBranchPersistence.findByPrimaryKey(masterBranchId);
			masterBranch.setActive(active);
		} catch (NoSuchMasterBranchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return masterBranchPersistence.update(masterBranch);
	}

	public List<MasterBranch> serachByName(String name) {
		return masterBranchPersistence.findBysearchByName(name);
	}	
}