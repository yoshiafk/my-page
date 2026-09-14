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
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.service.base.PetRemarksLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PetRemarks",
	service = AopService.class
)
public class PetRemarksLocalServiceImpl extends PetRemarksLocalServiceBaseImpl {

	/**
	 * Add New Pet Remarks
	 * 
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	public PetRemarks addPetRemarks(String name, String code, int active) throws PortalException {
		long petRemarksId = counterLocalService.increment();
		PetRemarks petremarks = petRemarksPersistence.create(petRemarksId);

		petremarks.setName(name);
		petremarks.setCode(code);
		petremarks.setActive(active);

		petRemarksPersistence.update(petremarks);

		return petremarks;
	}

	/**
	 * Update Pet Remarks
	 * 
	 * @param petRemarksId
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	public PetRemarks updatePetRemarks(long petRemarksId, String name, String code, int active) throws PortalException {
		PetRemarks petremarks = petRemarksPersistence.findByPrimaryKey(petRemarksId);

		petremarks.setPetRemarksId(petRemarksId);
		petremarks.setName(name);
		petremarks.setCode(code);
		petremarks.setActive(active);

		petRemarksPersistence.update(petremarks);

		return petremarks;
	}

	/**
	 * Get Remarks List
	 */
	public List<PetRemarks> getPetRemarks(int start, int end) {
		return petRemarksPersistence.findAll(start, end);
	}

	public List<PetRemarks> getPetRemarks() {
		return petRemarksPersistence.findAll();
	}

	/**
	 * Get Remarks Count
	 */
	public int getPetRemarksCount() {
		return petRemarksPersistence.countAll();
	}

	public PetRemarks setActive(long userId, long petRemarksId, int active, ServiceContext serviceContext)
			throws PortalException {
		PetRemarks petremarks = null;

		try {
			petremarks = petRemarksPersistence.findByPrimaryKey(petRemarksId);
			Date now = new Date();
			petremarks.setPetRemarksId(petRemarksId);
			petremarks.setActive(active);
			petremarks.setModifiedDate(serviceContext.getModifiedDate(now));

			petRemarksPersistence.update(petremarks);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return petremarks;
	}

    private static final Log log = LogFactoryUtil.getLog(PetRemarksLocalServiceImpl.class);
}