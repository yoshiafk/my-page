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
import com.mypage.admin.product.model.PetAnimalType;
import com.mypage.admin.product.service.base.PetAnimalTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PetAnimalType",
	service = AopService.class
)
public class PetAnimalTypeLocalServiceImpl
	extends PetAnimalTypeLocalServiceBaseImpl {
	
	public PetAnimalType addPetAnimalType(String name, int active) throws PortalException {
		long petAnimalTypeId = counterLocalService.increment();
		PetAnimalType petAnimalType = petAnimalTypePersistence.create(petAnimalTypeId);
		
		petAnimalType.setName(name);
		petAnimalType.setActive(active);
		petAnimalTypePersistence.updateImpl(petAnimalType);
		
		return petAnimalType;
	}
	
	public PetAnimalType updatePetAnimalType(long petAnimalTypeId, String name, int active) throws PortalException {
		PetAnimalType petAnimalType = petAnimalTypePersistence.findByPrimaryKey(petAnimalTypeId);
		
		petAnimalType.setName(name);
		petAnimalType.setActive(active);
		petAnimalTypePersistence.updateImpl(petAnimalType);
		
		return petAnimalType;
	}
	
	public PetAnimalType setActive(long petAnimalTypeId, int active, ServiceContext serviceContext) throws PortalException {
		PetAnimalType petAnimalType = null;
		
		try {
			Date now = new Date();
			
			petAnimalType = petAnimalTypePersistence.findByPrimaryKey(petAnimalTypeId);
			petAnimalType.setActive(active);
			petAnimalType.setModifiedDate(serviceContext.getModifiedDate(now));
			petAnimalTypePersistence.updateImpl(petAnimalType);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return petAnimalType;
	}
	
	public List<PetAnimalType> findByName(String name) {
		return petAnimalTypePersistence.findByfindByName(name);
	}
	
	public PetAnimalType searchPetAnimalTypeId(long petAnimalTypeId) {
		return petAnimalTypePersistence.fetchBysearchPetAnimalTypeId(petAnimalTypeId);
	}	
}