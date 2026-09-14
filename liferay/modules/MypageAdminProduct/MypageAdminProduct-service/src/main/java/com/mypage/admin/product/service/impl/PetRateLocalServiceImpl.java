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
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.service.base.PetRateLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PetRate",
	service = AopService.class
)
public class PetRateLocalServiceImpl extends PetRateLocalServiceBaseImpl {

	/**
	 * Add New Pet Rate
	 */
	public PetRate addPetRate(long petPlanId, long petRemarksId, String petRate, int active) throws PortalException {
		long petRateId = counterLocalService.increment();
		PetRate petrate = petRatePersistence.create(petRateId);

		petrate.setPetPlan(petPlanId);
		petrate.setPetRemarks(petRemarksId);
		petrate.setRate(petRate);
		petrate.setActive(active);

		petRatePersistence.update(petrate);

		return petrate;
	}

	public PetRate updatePetRate(long petRateId, long petPlanId, long petRemarksId, String petRate, int active)
			throws PortalException {
		PetRate petrate = petRatePersistence.findByPrimaryKey(petRateId);

		petrate.setPetRateId(petRateId);
		petrate.setPetPlan(petPlanId);
		petrate.setPetRemarks(petRemarksId);
		petrate.setRate(petRate);
		petrate.setActive(active);

		petRatePersistence.update(petrate);

		return petrate;
	}

	/**
	 * Get Rate List
	 */
	public List<PetRate> getPetRates(int start, int end) {
		return petRatePersistence.findAll(start, end);
	}
	
	public List<PetRate> getPetRates() {
		return petRatePersistence.findAll();
	}

	/**
	 * Get Rates Count
	 */
	public int getPetRatesCount() {
		return petRatePersistence.countAll();
	}

	public PetRate getSingleRateCoba(long petRateId) {
		return petRatePersistence.fetchByPrimaryKey(petRateId);
	}

	public List<Object[]> getAllPetRateCombinedWithPlanAndRemarks() {
		return petRateFinder.getAllPetRateCombinedWithPlanAndRemarks();
	}

	/**
	 * Set status for pet rate
	 */
	public PetRate setActive(long userId, long petRateId, int active, ServiceContext serviceContext)
			throws PortalException {
		PetRate petRate = null;

		try {
			petRate = petRatePersistence.findByPrimaryKey(petRateId);
			Date now = new Date();
			petRate.setPetRateId(petRateId);
			petRate.setActive(active);
			petRate.setModifiedDate(serviceContext.getModifiedDate(now));

			petRatePersistence.update(petRate);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return petRate;
	}
	
	public PetRate searchByPetPlanAndPetRemarks(long petPlan, long petRemarks) {
		return petRatePersistence.fetchBysearchByPetPlanAndPetRemarks(petPlan, petRemarks);
	}

    private static final Log log = LogFactoryUtil.getLog(PetRateLocalServiceImpl.class);
}